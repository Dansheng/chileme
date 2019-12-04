package com.clm.Controller;

import java.util.HashMap;

import com.clm.Service.LoginService;
import com.clm.Service.RegisterService;
import com.clm.Service.UploadDishService;

public class Controller {
	private static Controller controller = new Controller();
	private Controller() {
		
	}
	public static Controller getInstance() {
		return controller;
	}
	// for login 
	public HashMap<String,Integer> login(Integer workId,String password,String type) {
		LoginService login = LoginService.getInstance();
		HashMap<String,Integer> result = login.login(workId, password,type);
		return result;
	}
	// for register
	public boolean register(Integer workId,String name,String position,String phoneNumber,String email,String password){
		RegisterService register = RegisterService.getInstance();
		try {
			if(register.register(workId, name, position, phoneNumber, email, password))
				return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	// for upload a dish
	public boolean uploadDish(String dishName,Double dishPrice,Integer dishNumber,String local_img_url,String dishDesc){
		UploadDishService uploadDishService = UploadDishService.getInstance();
		try {
			if(uploadDishService.uploadDish(dishName, dishPrice, dishNumber, local_img_url, dishDesc))
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;		
		
	}
}
