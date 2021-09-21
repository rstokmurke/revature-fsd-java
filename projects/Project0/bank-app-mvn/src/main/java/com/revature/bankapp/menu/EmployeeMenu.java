package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

public class EmployeeMenu extends Menu {
	public EmployeeMenu (String name) {
		super(name);
		
		addMenuItem("Add New Customer.");
		addMenuItem("View account details.");
		addMenuItem("Log Out");
	}

	@Override
	void handleAction() {

		if (selection > menuItems.size() || selection < 1) {
			System.out.println("Please Choose valid option.");
			displayMenuAndCaptureSelection();
		} else {
			//System.out.println("Selected option is :" + selection);

		}

		Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			System.out.println(" ");
			System.out.println("--- Register New Customer ---");
			System.out.println(" ");
			//Scanner scanner = new Scanner(System.in);
			System.out.println("First name:");
			String firstName = scanner.nextLine();
			
			System.out.println("Last name:");
			String lastName = scanner.nextLine();
			
			System.out.println("Email:");
			String email = scanner.nextLine();
			
			System.out.println("Password :");
			String password = scanner.nextLine();
			
			CustomerDaoImpl customerdao = new CustomerDaoImpl();
		try {
			customerdao.create(new Customer(firstName ,lastName, email, password));
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
			System.out.println("Customer added successfully.");
			//displayMenuAndCaptureSelection();
			LoginForm loginform = new LoginForm("Login Form");
			loginform.captureDataAndPerformAction();
			
			CustomerMenuAfterLogin cust = new CustomerMenuAfterLogin ("Account Holder Menu");
			cust.displayMenuAndCaptureSelection();
	
			
			break;
		case 2:
			EmployeeDaoImpl accdao = new EmployeeDaoImpl();
			try {
				accdao.list();
				//accdao.create(new Account());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 3:
			System.out.println("Log out successfully");
			MainMenu menu = new MainMenu ("Main Menu");
			menu.displayMenuAndCaptureSelection();
		}
	}
	}
