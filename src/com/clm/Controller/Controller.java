package com.clm.Controller;

import java.util.HashMap;

import com.clm.Service.LoginService;
import com.clm.Service.RegisterService;

public class Controller {
	private static Controller controller = new Controller();
	private Controller() {
		
	}
	public static Controller getInstance() {
		return controller;
	}
	// for login 
	public boolean login(Integer workId,String password) {
		LoginService login = LoginService.getInstance();
		//HashMap<String,String> result = login.login(workId, password);
		return true;
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
}
