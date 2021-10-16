package com.revature.bankapp.model;

import java.util.ArrayList;

public class Customer {
//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
//				+ ", password=" + password + "]";
//	}
	@Override
	public String toString() {
		return "Customer_id = " + id + ", FirstName = " + firstname + ", LastName = " + lastname +"   " + account
				;
	}

	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Account account;
	private  ArrayList<Account> accountList;
	
	public void setId(long id) {
		this.id = id;
	}

	public Customer() {
		
	}
	
	public Customer(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setLastName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setAccount(Account account) {
		// TODO Auto-generated method stub
		
	}
	

}
