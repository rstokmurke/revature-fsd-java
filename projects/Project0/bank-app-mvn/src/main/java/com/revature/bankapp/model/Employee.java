package com.revature.bankapp.model;

import java.io.Reader;

public class Employee {
		private String firstname;
		private String lastname;
		private long id;
		private String accountNo;
		private double balance;
		private char status;
		
		public Employee(String firstname, String lastname, String accountNo, double balance, char status) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.accountNo = accountNo;
			this.balance = balance;
			this.status = status;
			
			
			//this.email = email;
			//this.password = password;
		}
		public String getAccountNo() {
			return accountNo;
		}

		public char getStatus() {
			return status;
		}

		public void setStatus(char status) {
			this.status = status;
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

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		

		public void setId(long id) {
			this.id = id;
		}

		public long getId() {
			return id;
		}
		
		@Override
		public String toString() {
			return "Account Details [First Name=" + firstname+ ",Last Name=" + lastname+ ",AccountNo=" + accountNo + ", Balance=" + balance +",Status=" + status + "]";
		}
		public void setStatus(Reader characterStream) {
			// TODO Auto-generated method stub
			
		}
	}

