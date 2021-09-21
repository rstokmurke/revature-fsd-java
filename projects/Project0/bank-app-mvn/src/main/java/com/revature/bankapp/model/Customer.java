package com.revature.bankapp.model;

public class Customer {
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	private static long counter = 0;
	
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
	

}
