package com.revature.bankapp.model;

import java.io.Reader;

public class Employee {
		private String email;
		private String password;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	}
	
//		private String firstname;
//		private String lastname;
//		private long id;
//		private String accountNo;
//		private double balance;
//		private char status;
//		private int customerid;
//		
//		public Employee(String firstname, String lastname, String accountNo, double balance, char status, int customerid) {
//			super();
//			this.firstname = firstname;
//			this.lastname = lastname;
//			this.accountNo = accountNo;
//			this.balance = balance;
//			this.status = status;
//			this.customerid = customerid;
//			
//			
//			//this.email = email;
//			//this.password = password;
//		}
//
//		public String getFirstname() {
//			return firstname;
//		}
//
//		public void setFirstname(String firstname) {
//			this.firstname = firstname;
//		}
//
//		public String getLastname() {
//			return lastname;
//		}
//
//		public void setLastname(String lastname) {
//			this.lastname = lastname;
//		}
//
//		public long getId() {
//			return id;
//		}
//
//		public void setId(long id) {
//			this.id = id;
//		}
//
//		public String getAccountNo() {
//			return accountNo;
//		}
//
//		public void setAccountNo(String accountNo) {
//			this.accountNo = accountNo;
//		}
//
//		public double getBalance() {
//			return balance;
//		}
//
//		public void setBalance(double balance) {
//			this.balance = balance;
//		}
//
//		public char getStatus() {
//			return status;
//		}
//
//		public void setStatus(char status) {
//			this.status = status;
//		}
//
//		public int getCustomerid() {
//			return customerid;
//		}
//
//		public void setCustomerid(int customerid) {
//			this.customerid = customerid;
//		}
//
//		@Override
//		public String toString() {
//			return "Account details: [firstname= " + firstname + ", lastname= " + lastname + ", accountNo= "
//					+ accountNo + ", balance= " + balance + ", status= " + status + ", customerid= " + customerid + "]";
//		}
//
//		public void setStatus(Reader characterStream) {
//			// TODO Auto-generated method stub
//			
//		}
//		

