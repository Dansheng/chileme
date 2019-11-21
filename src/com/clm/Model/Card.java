package com.clm.Model;

public class Card {
	Integer WorkerId;
	String cardNumber;
	Double balance;
	Card(){
		balance = 0.00;
	}
	// get 
	public Integer getWorkerId() {
		return WorkerId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public Double getBalance() {
		return balance;
	}
	// set
	public boolean setWorkerId() {
		return true;
	}
	public boolean setCardNumber() {
		return true;
	}
	public boolean setBalance() {
		return true;
	}
	// saveMoney
	public boolean deposit(double money) {
		try {
			balance += money;
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	
}
