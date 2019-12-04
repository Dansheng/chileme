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
	public HashMap<String,Integer> login(Integer workId,String password,Integer type) {
		Worker worker = new Worker(workId,password);
		WorkerDao workDao = new WorkerDao();
		worker.setWorkId(workId);
		worker.setPassword(password);
		if(type == 1) {
			worker.setPosition("普通员工");
		}
		else if(type == 2){
			worker.setPosition("餐厅员工");
		}
		else if(type == 3) {
			worker.setPosition("管理员");
		}
		Hashmap<String,Integer> result = workDao.CheckPas(worker);
		return result;
	}
}
