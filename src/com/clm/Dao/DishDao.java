package com.clm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.clm.Model.Dish;

public class DishDao {
//	private static ArrayList<Dish> menu=new ArrayList<Dish>();
//	public  static ArrayList<Dish> getMenu()
//	{
//		return menu;
//	}
	public static ArrayList<HashMap<String,String>> Querydish()
	{
		ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT* FROM dish";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				HashMap<String,String> map=new HashMap<String,String>();
				map.put("dishName", rs.getString("dishName"));
				map.put("price",rs.getString("price"));
				map.put("avaNumber", rs.getString("avaNumber"));
				map.put("image", rs.getString("image"));
				map.put("description", rs.getString("description"));
				map.put("type",rs.getString("type"));
				list.add(map);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<HashMap<String,String>> Querydish(String type)
	{
		ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT* FROM dish WHERE type='"+type+"'";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				HashMap<String,String> map=new HashMap<String,String>();
				map.put("dishName", rs.getString("dishName"));
				map.put("price",rs.getString("price"));
				map.put("avaNumber", rs.getString("avaNumber"));
				map.put("image", rs.getString("image"));
				map.put("description", rs.getString("description"));
				map.put("type",rs.getString("type"));
				list.add(map);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
//	public Dish Querydish(Integer dishId)
//	{
//		Dish dish=null;
//		try
//		{
//			Statement stmt=JdbcUnit.getConnection().createStatement();
//			String query="SELECT* FROM dish WHERE dishId="+dishId.toString();
//			ResultSet rs=stmt.executeQuery(query);
//			while(rs.next())
//			{
//				dish=new Dish(rs.getInt("dishId"));
//				dish.setDishName(rs.getString("dishName"));
//				dish.setPrice(rs.getDouble("price"));
//				dish.setAvaNumber(rs.getInt("avaNumber"));
//				dish.setImage_url(rs.getString("image"));
//				dish.setDescription(rs.getString("description"));
//				
//			}
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
//		}catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return dish;
//	}
	public boolean insertDish(Dish dish)
	{
		Integer s=null;
		try
		{
			//System.out.println("test");
			//System.out.println(JdbcUnit.getConnection());
			Statement stmt=JdbcUnit.getConnection().createStatement();
			//System.out.println("test2");
			String insert="INSERT INTO dish(dishId,dishName,price,avaNumber,image,description,type) VALUES("+dish.getDishId()+",'"+dish.getDishName()+"',"+dish.getPrice()+","+dish.getAvaNumber()+",'"+dish.getImage_url()+"','"+dish.getDescription()+"','"+dish.getType()+"')";
			System.out.println(insert);
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
			String query="SELECT COUNT(*) FROM dish";
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
//	public static void main(String[] args)
//	{
//		Integer i=getDishId();
//		System.out.println(i);
//		DishDao dishDao=new DishDao();
//		Dish dish=new Dish(i);
//		dish.setDishName("水煮肉片");
//		dish.setPrice(4300.998);
//		dish.setAvaNumber(10);
//		dish.setImage_url("www.baidfsfd.gsg");
//		dish.setDescription("delicious");
//		dish.setType("川湘菜");
//		System.out.println(dishDao.insertDish(dish));
//		i=getDishId();
//		System.out.println(i);
//		Dish dish2=new Dish(i);
//		dish2.setDishName("剁椒鱼头");
//		dish2.setPrice(4300.998);
//		dish2.setAvaNumber(10);
//		dish2.setImage_url("www.baidfsfd.gsg");
//		dish2.setDescription("delicious");
//		dish2.setType("川湘菜");
//		System.out.println(dishDao.insertDish(dish2));
//		i=getDishId();
//		System.out.println(i);
//		Dish dish3=new Dish(i);
//		dish3.setDishName("早茶");
//		dish3.setPrice(4300.998);
//		dish3.setAvaNumber(10);
//		dish3.setImage_url("www.baidfsfd.gsg");
//		dish3.setDescription("delicious");
//		dish3.setType("粤菜");
//		System.out.println(dishDao.insertDish(dish3));
////		System.out.println(dishDao.Querydish(1));
//		dishDao.Querydish();
//		System.out.println(dishDao.Querydish("川湘菜"));
//	}
}
