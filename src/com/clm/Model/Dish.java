package com.clm.Model;

public class Dish {
	Integer dishId;
	String dishName;
	Double price;
	Integer avaNumber;
	String image_url;
	String description;
	String type;
	public Dish(Integer dishId){
		setDishId(dishId);
	}
	public Dish(String dishName,Double price){
		setDishName(dishName);
		setPrice(price);
	}
	public Integer getDishId() {
		return dishId;
	}
	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvaNumber() {
		return avaNumber;
	}
	public void setAvaNumber(Integer avaNumber) {
		this.avaNumber = avaNumber;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	
}
