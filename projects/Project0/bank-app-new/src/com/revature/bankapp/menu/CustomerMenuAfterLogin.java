package com.revature.bankapp.menu;

import java.util.Scanner;

import com.revature.bankapp.model.AccountManager;
import com.revature.bankapp.model.AccountNoGenerator;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class CustomerMenuAfterLogin extends Menu {

	public CustomerMenuAfterLogin(String name) {
		super(name);
		addMenuItem("Apply for new acc");
		addMenuItem("Perform Transaction");
		addMenuItem("View Details");
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
			System.out.println("\n*****");
			System.out.println("New Account details");
			System.out.println("*****\n");
			// Scanner scanner = new Scanner(System.in);
			System.out.println("First name:");
			String firstName = scanner.nextLine();

			System.out.println("Last name:");
			String lastName = scanner.nextLine();

			System.out.println("Address:");
			String address = scanner.nextLine();

			System.out.println("Date of Birt:");
			String opBalance = scanner.nextLine();

			DataManager.addCustomer(new Customer(firstName, lastName, address, opBalance));
			System.out.println("New account created successfully.");
			//System.out.println("Your Account number is: ");
			
			//AccountNoGenerator account = new AccountNoGenerator();
			//System.out.println(account. AccountNoGenerator());
			
			displayMenuAndCaptureSelection();
			break;

		case 2:
			AccountManager accountManager = new AccountManager();
			accountManager.AccountManager();
			
			break;
		case 3:
			break;
		case 4:
			System.out.println("Log out successfully");
			MainMenu menu = new MainMenu ("Main Menu");
			menu.displayMenuAndCaptureSelection();
			break;
		}
	}
}
