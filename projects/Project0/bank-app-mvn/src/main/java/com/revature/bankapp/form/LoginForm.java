package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.menu.CustomerMenuAfterLogin;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;


public class LoginForm extends Form {
	private String email;
	private String password;
	
	public LoginForm(String name) {
		super(name);
	}
	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Email:");
		email = scanner.nextLine();
		
		System.out.println("Password:");
		password = scanner.nextLine();
		
	}
	@Override
	public void action() {
		 CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer;
		try {
			customer = customerDaoImpl.getCustomerByEmail(email);
			if (customer == null) {
				System.out.println("Invalid Password or Email");
			} else if (customer.getPassword().equals(password)) {
				success = true;
				//DataManager.setcurrentCustomer(customer);
				System.out.println("Login Successful");
				System.out.println("Welcome " + customer.getFirstname());
				CustomerMenuAfterLogin customerMenu = new CustomerMenuAfterLogin("Customer Menu");
				customerMenu.displayMenuAndCaptureSelection();

			} else  {
				System.out.println("Invalid Password or Email");
			}

		} catch (SQLException e) {
			System.out.println("Failed to get customer");;
		}
	}
}

