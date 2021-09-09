package com.revature.bankapp.menu;
import java.util.Scanner;

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
				System.out.println("\n*****");
				System.out.println("Register New Customer\n");
				System.out.println("*****\n");
				//Scanner scanner = new Scanner(System.in);
				System.out.println("First name:");
				String firstName = scanner.nextLine();
				
				System.out.println("Last name:");
				String lastName = scanner.nextLine();
				
				System.out.println("Email:");
				String email = scanner.nextLine();
				
				System.out.println("Password :");
				String password = scanner.nextLine();
				
				DataManager.addCustomer(new Customer(firstName, lastName, email, password));
				System.out.println("Customer added successfully.");
				displayMenuAndCaptureSelection();
				break;
				
			case 2:
				LoginForm loginform = new LoginForm("Login Form");
				loginform.captureDataAndPerformAction();
				break;
			case 3:
				break;
			case 4:
				break;
	}	
	}
	
}
