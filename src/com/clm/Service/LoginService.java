package com.clm.Service;

import java.util.HashMap;

import com.clm.Dao.WorkerDao;
import com.clm.Model.Worker;

public class LoginService {
	private  static LoginService loginService = new LoginService();
	private LoginService() {
		
	}
	public static LoginService getInstance() {
		return loginService;
	}
	public HashMap<String,Integer> login(Integer workId,String password,String type) {
		Worker worker = new Worker(workId,password);
		WorkerDao workDao = new WorkerDao();
		worker.setWorkId(workId);
		worker.setPassword(password);
		worker.setPosition(type);
		Hashmap<String,Integer> result = workDao.CheckPas(worker);
		return result;
	}
}
