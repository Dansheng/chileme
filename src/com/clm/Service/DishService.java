package com.clm.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.clm.Dao.DishDao;

public class DishService {
	private static DishService dishService=new DishService();
	public DishService()
	{
	}
	public static DishService getInstance()
	{
		return dishService;
	}
	public ArrayList<HashMap<String,String>> getMenu(Integer type)
	{
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		{
			map.put(0, "全部菜单");
			map.put(1,"川湘菜");
			map.put(2, "西北菜");
			map.put(3, "江浙菜");
			map.put(4, "新疆菜");
			map.put(5, "东北菜");
			map.put(6, "粤菜");
			map.put(7, "西餐");
			map.put(8, "日本料理");
			map.put(9, "韩式简餐");
			map.put(10,"小吃夜宵");
			map.put(11, "甜品饮品");
		}
		DishDao dishDao=new DishDao();
		if(map.get(type)=="全部菜单")
		{
			return dishDao.Querydish();
		}
		else 
		{
			return dishDao.Querydish(map.get(type));
		}
	}
//	public static void main(String[] args)
//	{
//		System.out.println(getInstance().getMenu(0));
//		System.out.println(getInstance().getMenu(1));
//	}
}
