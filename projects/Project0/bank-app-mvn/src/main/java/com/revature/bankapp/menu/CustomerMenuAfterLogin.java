package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.AccountManager;
import com.revature.bankapp.model.Customer;

public class CustomerMenuAfterLogin extends Menu {

	public CustomerMenuAfterLogin(String name) {
		super(name);
		addMenuItem("Apply for new account");
		addMenuItem("Perform Transaction");
		addMenuItem("View Account Details");
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
			//Scanner scanner = new Scanner(System.in);
			System.out.println("Account No:");
			String accountNo = scanner.nextLine();

			System.out.println("Initial Balance:");
			double balance = scanner.nextDouble();

			/*System.out.println("Address:");
			String address = scanner.nextLine();

			System.out.println("Initial Balance:");
			String opBalance = scanner.nextLine();*/
			
			AccountDaoImpl accountdao = new AccountDaoImpl();
			try {
				accountdao.create(new Account(accountNo,balance));
				//accountdao.create(new Account());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			//DataManager.addCustomer(new Customer(accountNo, balance, address, opBalance));
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
			AccountDaoImpl accdao = new AccountDaoImpl();
			try {
				accdao.list();
				//accdao.create(new Account());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CustomerMenuAfterLogin custMenu1 = new CustomerMenuAfterLogin ("Account Holder Menu");
			custMenu1.displayMenuAndCaptureSelection();
			break;
		case 4:
			System.out.println("Log out successfully");
			MainMenu menu = new MainMenu ("Main Menu");
			menu.displayMenuAndCaptureSelection();
			break;
		}
	}
}
