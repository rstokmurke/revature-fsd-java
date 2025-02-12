package com.revature.bankapp.menu;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;
public class MainMenu extends Menu {

	public MainMenu(String name) {
		super(name);
		addMenuItem("Register new Customer");
		addMenuItem("Login as Customer");
		addMenuItem("Login as Employee");
		addMenuItem("Exit");
	}

	@Override
	void handleAction() {
		
		if (selection > menuItems.size() || selection < 1) {
			System.out.println("Please Choose valid option.");
			displayMenuAndCaptureSelection();
		}else {
			//System.out.println("Selected option is :"+ selection);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//DataManager.addCustomer(new Customer(firstName, lastName, email, password));
				System.out.println("Customer added successfully.");
				displayMenuAndCaptureSelection();
				break;
				
			case 2:
				LoginForm loginform = new LoginForm("Login Form");
				loginform.captureDataAndPerformAction();
				
				CustomerMenuAfterLogin cust = new CustomerMenuAfterLogin ("Account Holder Menu");
				cust.displayMenuAndCaptureSelection();
		
				break;
			case 3:
				//String username ="user";
				//String passwordd = "password";
				
				System.out.println(" ");
				System.out.println("--- Employee Login ---");
				System.out.println(" ");
				
				System.out.println("Username:");
				String user = scanner.nextLine();
				
				System.out.println("Password :");
				String pass = scanner.nextLine();
				
				if (user.equals("user") && pass.equals("password")) {
					System.out.println("Login Successful");
					
					EmployeeMenu emenu = new EmployeeMenu ("Employee Menu");
					emenu.displayMenuAndCaptureSelection();
					
				}else {
					System.out.println("Invalid Input");
					MainMenu menu = new MainMenu ("Main Menu");
					menu.displayMenuAndCaptureSelection();
				}
				
				break;
			case 4:
				break;
	}	
	}
	
}
