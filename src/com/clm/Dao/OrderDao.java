package com.clm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.clm.Model.Order;
import com.clm.Model.OrderInfo;


public class OrderDao {
	public boolean AddOrder(Order order)
	{
		Integer s1=null,s2=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String insert1="INSERT INTO orderW(orderId,workId,serveTime,serveAdd,payWay,payState,wordDescription,starDescription) VALUES("+order.getOrderId()+","+order.getWorkId()+",'"+order.getServeTime()+"','"+order.getServeAddress()+"','"+order.getPayWay()+"','"+order.getPayState()+"','"+order.getWordDescription()+"','"+order.getStarDescription()+"')";
			System.out.println(insert1);
			s1=stmt.executeUpdate(insert1);
			for(Integer i:order.getOrderInfo().getDish_count().keySet())
			{
				String insert2="INSERT INTO orderInfo(orderId,dishId,count,wordDescription,starDescription) VALUES("+order.getOrderId()+","+i+","+order.getOrderInfo().getDish_count().get(i)+",'"+order.getOrderInfo().getWordDescription()+"','"+order.getOrderInfo().getStarDesciption()+"')";
				s2=stmt.executeUpdate(insert2);
				System.out.println(insert2);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(s1!=0&&s2!=0)
		{
			return true;
		}
		else return false;
	}
	public Order QueryOrder(Integer OrderId)
	{
		OrderInfo orderinfo=new OrderInfo();
		Order order=new Order(orderinfo);
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query1="SELECT* FROM orderInfo WHERE orderId="+OrderId;
			System.out.println(query1);
			ResultSet rs=stmt.executeQuery(query1);
			while(rs.next())
			{
				orderinfo.setOrderId(rs.getInt("orderId"));
				orderinfo.getDish_count().put(rs.getInt("dishId"),rs.getInt("count"));
				orderinfo.setWordDescription(rs.getString("wordDescription"));
				orderinfo.setStarDesciption(rs.getInt("starDescription"));
			}
			String query2="SELECT* FROM orderW WHERE orderId="+OrderId;
			rs=stmt.executeQuery(query2);
			while(rs.next())
			{
				order.setOrderId(rs.getInt("orderId"));
				order.setWorkId(rs.getInt("workId"));
				order.setServeTime(rs.getString("serveTime"));
				order.setServeAddr(rs.getString("serveAdd"));
				order.setPayState(rs.getString("payState"));
				order.setPayWay(rs.getString("payWay"));
				order.setWordDescription(rs.getString("wordDescription"));
				order.setStarDescription(rs.getInt("starDescription"));
			}
			//System.out.println(order);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
	}
	public boolean setOrderState(Order order)
	{
		Integer s=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String set="UPDATE orderW SET payState='"+order.getPayState()+"' WHERE orderId="+order.getOrderId();
			s=stmt.executeUpdate(set);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(s!=0)
		{
			return true;
		}
		else return false;
	}
	public ArrayList<Order> getOrderList(int WorkerId)
	{
		ArrayList<Order> orderlist=new ArrayList<Order>();
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT* FROM orderW WHERE workId="+WorkerId;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				orderlist.add(QueryOrder(rs.getInt("orderId")));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderlist;
	}
	public static Integer getOrderId()
	{
		Integer orderNumber=null;
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query="SELECT COUNT(*) FROM orderW";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				orderNumber=rs.getInt(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderNumber+1;
	}

	
//		public static void main(String[] args)
//	{
//		OrderInfo orderinfo=new OrderInfo();
//		orderinfo.setOrderId(1);
//		orderinfo.getDish_count().put(1, 1);
//		orderinfo.setWordDescription("kaka");
//		orderinfo.setStarDesciption(2);
//		Order order=new Order(orderinfo);
//		order.setOrderId(1);
//		order.setWorkId(1);
//		order.setServeTime("2019年8月20");
//		order.setServeAddr("海棠");
//		order.setPayWay("cash");
//		order.setPayState("preparing");
//		order.setWordDescription("good");
//		order.setStarDescription(1);
//		Order order2=new Order(orderinfo);
//		order2.setOrderId(2);
//		order2.setWorkId(1);
//		order2.setServeTime("2019年11月28");
//		order2.setServeAddr("海棠");
//		order2.setPayWay("cash");
//		order2.setPayState("finished");
//		order2.setWordDescription("good");
//		order2.setStarDescription(1);
//		OrderDao orderdao=new OrderDao();
//		System.out.println(orderdao.AddOrder(order2));
//		System.out.println(orderdao.QueryOrder(1));
//		System.out.println(orderdao.setOrderState(order));
////		System.out.println(orderdao.getOrderList(1));
//		System.out.println(OrderDao.getOrderId());
//			System.out.println(getCurrentOrderNum());
//		
//	}
}
