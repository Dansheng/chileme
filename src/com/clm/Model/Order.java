package com.clm.Model;

public class Order {
	Integer workId;
	Integer orderId;
	String serveTime;
	String serveAddress;
	String payWay;
	String payState;
	String wordDescription;
	Integer starDescription;
	OrderInfo orderInfo;
	public Order(){
		
	}
	public Order(OrderInfo orderInfo){
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
	public String getPayState() {
		return this.payState;
	}
	public OrderInfo getOrderInfo()
	{
		return this.orderInfo;
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
	public void setPayState(String payState) {
		this.payState=payState;
	}
	public String getWordDescription() {
		return wordDescription;
	}
	public void setWordDescription(String wordDescription) {
		this.wordDescription = wordDescription;
	}
	public Integer getStarDescription() {
		return starDescription;
	}
	public void setStarDescription(Integer starDescription) {
		this.starDescription = starDescription;
	}
	@Override
	public String toString() {
		return "Order [workId=" + workId + ", orderId=" + orderId + ", serveTime=" + serveTime + ", serveAddress="
				+ serveAddress + ", payWay=" + payWay + ", payState=" + payState + ", wordDescription="
				+ wordDescription + ", starDescription=" + starDescription + ", orderInfo=" + orderInfo + "]";
	}	
}