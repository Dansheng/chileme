package com.clm.Service;

import com.clm.Dao.WorkerDao;
import com.clm.Model.Worker;

public class LoginService {
	private  static LoginService loginService = new LoginService();
	private LoginService() {
		
	}
	public static LoginService getInstance() {
		return loginService;
	}
	public boolean login(Integer workId,String password) {
		Worker worker = new Worker(workId,password);
		WorkerDao workDao = new WorkerDao();
		
		return true;
	}
}
