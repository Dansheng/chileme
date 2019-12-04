package com.clm.Service;

import com.clm.Dao.OrderDao;

public class OrderService {
	private static OrderService orderService=new OrderService();
	public OrderService()
	{
	}
	public static OrderService getInstance()
	{
		return orderService;
	}
	
}
