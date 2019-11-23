package com.clm.Model;

public class Order {
	Integer workId;
	Integer orderId;
	String serveTime;
	String serveAddress;
	String payWay;
	String payStatus;
	OrderInfo orderInfo;
	Order(){
		
	}
	Order(OrderInfo orderInfo){
		this.orderInfo = orderInfo;
	}
	// get
	public Integer getWorkId() {
		return workId;
	}
	public Integer getOrderId() {
		return this.orderId;
	}
	public String getServeTime() {
		return this.serveTime;
	}
	public String getServeAddress() {
		return this.serveAddress;
	}
	public String getPayWay() {
		return this.payWay;
	}
	public String getPayStatus() {
		return this.payStatus;
	}
	// set
	public void setWorkId(Integer id) {
		this.workId=id;
	}
	public void setOrderId(Integer id) {
		this.orderId=id;
	}
	public void setServeTime(String serveTime) {
		this.serveTime=serveTime;
	}
	public void setServeAddr(String newAddress) {
		this.serveAddress=newAddress;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus=payStatus;
	}	
}