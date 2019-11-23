package com.clm.Model;

import java.util.HashMap;

public class OrderInfo{
	Integer orderId;
	HashMap<Integer,Integer> dish_count = new HashMap<Integer,Integer>();
	String wordDescription;
	Integer starDesciption;
	public OrderInfo() {
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public HashMap<Integer, Integer> getDish_count() {
		return dish_count;
	}
	public void setDish_count(HashMap<Integer, Integer> dish_count) {
		this.dish_count = dish_count;
	}
	public String getWordDescription() {
		return wordDescription;
	}
	public void setWordDescription(String wordDescription) {
		this.wordDescription = wordDescription;
	}
	public Integer getStarDesciption() {
		return starDesciption;
	}
	public void setStarDesciption(Integer starDesciption) {
		this.starDesciption = starDesciption;
	}
	// add
	public void addDish(Integer dishId) {
		dish_count.put(dishId, 1);
	}
	public void addDish(Integer dishId,Integer count) {
		dish_count.put(dishId, count);
	}
}
