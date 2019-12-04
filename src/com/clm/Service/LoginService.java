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
		worker.setWorkId(workId);
		worker.setPassword(password);
		worker.setPosition(type);
		HashMap<String,Integer> result = WorkerDao.CheckPas(worker);
//		if(result.get("data")==1) {
//			if(type.equals("餐厅员工") || type.equals("管理员")) {
//				result.put("data",4);
//			}
//		}
//		else if(result.get("data")==2) {
//			if(type.equals("管理员")) {
//				result.put("data",4);
//			}
//		}
		
		return result;
	}
}
