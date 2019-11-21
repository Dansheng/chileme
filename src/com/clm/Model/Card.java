package com.clm.Model;

public class Card {
	Integer WorkerId;
	String cardNumber;
	Double balance;
	public Card(){
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
	public void setWorkerId(Integer WorkerId) {
		this.WorkerId=WorkerId;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber=cardNumber;
	}
	public void setBalance(double balance) {
		this.balance=balance;
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
	//drawMoney
	public boolean draw(double money) {
		try {
			if(balance > money)
				balance -= money;
			else {
				System.out.println("Error:money is not enough!!!");
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	
}
