package com.clm.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		Order order=new Order();
		try
		{
			Statement stmt=JdbcUnit.getConnection().createStatement();
			String query1="SELECT * FROM orderW WHERE orderId="+OrderId;
			ResultSet rs=stmt.executeQuery(query1);
			while(rs.next())
			{
				order.setOrderId(rs.getInt("orderId"));
				order.setWorkId(rs.getInt("workId"));
				order.setServeTime(rs.getString("serveTime"));
				order.setServeAddr(rs.getString("serveAdd"));
				order.setPayWay(rs.getString("payWay"));
				order.setPayState(rs.getString("payState"));
				order.setWordDescription(rs.getString("wordDescription"));
				order.setStarDescription(rs.getInt("starDescription"));
			}
//			String query="SELECT * FROM orderInfo WHERE orderId="+OrderId;
//			System.out.println(query);
//			
//			ResultSet r=stmt.executeQuery(query);
//			System.out.println(r.getInt("orderId"));
//			
//			System.out.println(r.first());
//			while(r.next())
//			{
//				order.getOrderInfo().getDish_count().put(r.getInt("dishId"), r.getInt("count"));
//			}
//			System.out.println(order);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return order;
	}
	public static void main(String[] args)
	{
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
//		order.setPayState("finished");
//		order.setWordDescription("good");
//		order.setStarDescription(1);
//		OrderDao orderdao=new OrderDao();
////		System.out.println(orderdao.AddOrder(order));
//		System.out.println(orderdao.QueryOrder(1));
		
	}
}
