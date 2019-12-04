package com.clm.Service;

import com.clm.Dao.DishDao;
import com.clm.Model.Dish;

public class UploadDishService {
	private  static UploadDishService uploadDishService = new UploadDishService();
	private UploadDishService() {
		
	}
	public static UploadDishService getInstance() {
		return uploadDishService;
	}
	public boolean uploadDish(String dishName,Double dishPrice,Integer dishNumber,String local_img_url,String dishDesc) {
		Dish dish = new Dish(DishDao.getDishId());
		try {
			dish.setDishName(dishName);
			dish.setPrice(dishPrice);
			dish.setAvaNumber(dishNumber);
			dish.setDescription(dishDesc);
			/* upload image */
			dish.setImage_url(local_img_url);
			/* add dish to database */
			DishDao dishDao = new DishDao();
			dishDao.insertDish(dish);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
