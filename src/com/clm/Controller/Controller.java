package com.clm.Controller;

import com.clm.Service.LoginService;

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
		login.login(workId, password);
		return true;
	}
}
