package com.clm.Model;

public class Worker {
	Integer workId;
	String name;
	String position;
	String phoneNumber;
	String email;
	// password?
	
	Worker(String name){
		// todo:get default_workId from mysql
		setName(name);
	}
	// get
	public Integer getWorkId() {
		return 0;
	}
	public String getName() {
		return this.name;
	}
	public String getPosition() {
		return this.getPosition();
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getEmail() {
		return this.email;
	}
	// set
	// todo:Dao
	public void setWorkId(Integer id) {
		this.workId=id;
		//Dao 
	}
	public void setName(String newName) {
		this.name=newName;
	}
	public void setPosition(String newPosition) {
		this.position=newPosition;
	}
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber=newPhoneNumber;
	}
	public void setEmail(String newEmail) {
		this.email=newEmail;
	}
	
}
