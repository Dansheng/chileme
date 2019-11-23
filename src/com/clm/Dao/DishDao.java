package com.clm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.clm.Model.Dish;

public class DishDao {
	private static ArrayList<Dish> menu=new ArrayList<Dish>();
	public  static ArrayList<Dish> getMenu()
	{
		return menu;
	}
	public static void Querydish()
	{
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT* FROM dish";
			ResultSet rs=(ResultSet) stmt.executeQuery(query);
			while(rs.next())
			{
				Dish dish=new Dish(rs.getInt("dishId"));
				dish.setDishName(rs.getString("dishName"));
				dish.setPrice(rs.getDouble("price"));
				dish.setAvaNumber(rs.getInt("avaNumber"));
				dish.setImage_url(rs.getString("image"));
				dish.setDescription(rs.getString("description"));
				menu.add(dish);
			}
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public Dish Querydish(Integer dishId)
	{
		Dish dish=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT* FROM dish WHERE dishId="+dishId.toString();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				dish=new Dish(rs.getInt("dishId"));
				dish.setDishName(rs.getString("dishName"));
				dish.setPrice(rs.getDouble("price"));
				dish.setAvaNumber(rs.getInt("avaNumber"));
				dish.setImage_url(rs.getString("image"));
				dish.setDescription(rs.getString("description"));
				
			}
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dish;
	}
	public boolean insertDish(Dish dish)
	{
		Integer s=null;
		try
		{
			//System.out.println("test");
			//System.out.println(JdbcUnit.getConnection());
			Statement stmt=JdbcUnit.getConnection().createStatement();
			//System.out.println("test2");
			String insert="INSERT INTO dish(dishId,dishName,price,avaNumber,image,description) VALUES("+dish.getDishId()+",'"+dish.getDishName()+"',"+dish.getPrice()+","+dish.getAvaNumber()+",'"+dish.getImage_url()+"','"+dish.getDescription()+"')";
			//System.out.println(insert);
			s=stmt.executeUpdate(insert);
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(s!=null)
		{
			return true;
		}
		else return false;
	}
	public static Integer getDishId()
	{
		Integer dishNumber=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT COUNT(*) FROM orderW";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				dishNumber=rs.getInt(1);
			}
//			if(stmt!=null)
//			{
//				try
//				{
//					stmt.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
//			JdbcUnit.CloseConnection();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dishNumber+1;
	}
	public static void main(String[] args)
	{
		Integer i=getDishId();
		System.out.println(i);
		DishDao dishDao=new DishDao();
		Dish dish=new Dish(i);
		dish.setDishName("tofu");
		dish.setPrice(20.0);
		dish.setAvaNumber(10);
		dish.setImage_url("www.baidu.com");
		dish.setDescription("delicious");
		System.out.println(dishDao.insertDish(dish));
		System.out.println(dishDao.Querydish(1));
		dishDao.Querydish();
		Iterator iterator=menu.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
