package com.clm.Service;

import com.clm.Dao.WorkerDao;
import com.clm.Model.Worker;

public class RegisterService {
	private  static RegisterService registerService = new RegisterService();
	private RegisterService() {
		
	}
	public static RegisterService getInstance() {
		return registerService;
	}
	public boolean register(Integer workId,String name,String position,String phoneNumber,String email,String password) {
		Worker worker = new Worker(workId,password);
		worker.setName(name);
		worker.setPosition(position);
		worker.setPhoneNumber(phoneNumber);
		worker.setEmail(email);
		WorkerDao workerDao = new WorkerDao();
		workerDao.AddWorker(worker);
		return true;
	}
}
