package com.revature.bankapp.model;

import java.io.Reader;
import java.util.ArrayList;

public class Account {
	private long id;
	private String accountNo;
	private double balance;
	private int customerid;
	
	public Account() {}
	
	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
//		this.customerid = customerid;
		
		//this.email = email;
		//this.password = password;
	}
	public String getAccountNo() {
		return accountNo;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Account Details [AccountNo=" + accountNo + ", Balance=" + balance +"]";
	}
	public void setStatus(Reader characterStream) {
		// TODO Auto-generated method stub
		
	}
}

