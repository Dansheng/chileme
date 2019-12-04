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
	public boolean uploadDish(String dishName,Double dishPrice,Integer dishNumber,String local_img_url,String dishDesc,String type) {
		Integer i=DishDao.getDishId();
//		System.out.println(i);
		Dish dish = new Dish(i);
		try {
			dish.setDishName(dishName);
			dish.setPrice(dishPrice);
			dish.setAvaNumber(dishNumber);
			dish.setDescription(dishDesc);
			dish.setType(type);
			/* upload image */
			dish.setImage_url(UploadImageService.uploadImage(local_img_url));
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
//	public static void main(String[] args)
//	{
		
//		String dishName="水煮肉片";
//		Double dishPrice=28.0;
//		Integer dishNumber=30;
//		String local_img_url="/Users/wanghanyi/Desktop/shuizhuroupian.jpg";
//		String dishDesc="超级好吃！";
//		String type="川湘菜";
//		System.out.println(UploadDishService.getInstance().uploadDish(dishName,dishPrice,dishNumber,local_img_url,dishDesc,type));
//		String dishName="酸菜鱼";
//		Double dishPrice=32.0;
//		Integer dishNumber=30;
//		String local_img_url="/Users/wanghanyi/Desktop/suancaiyu.jpg";
//		String dishDesc="酸爽麻辣，无敌爆炸好吃！";
//		String type="川湘菜";
//		System.out.println(UploadDishService.getInstance().uploadDish(dishName,dishPrice,dishNumber,local_img_url,dishDesc,type));
//		String dishName="毛血旺";
//		Double dishPrice=36.0;
//		Integer dishNumber=30;
//		String local_img_url="/Users/wanghanyi/Desktop/maoxuwang.jpg";
//		String dishDesc="麻辣鲜香，一起感受舌尖上的四川";
//		String type="川湘菜";
//		System.out.println(UploadDishService.getInstance().uploadDish(dishName,dishPrice,dishNumber,local_img_url,dishDesc,type));
//	}
}
