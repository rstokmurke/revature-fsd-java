package com.revature.bankapp.model;

import java.util.Scanner;

import com.revature.bankapp.menu.CustomerMenuAfterLogin;

public class AccountManager {

	public static void main(String args[]) {
		AccountManager();
	}

	public static void AccountManager() {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1] Deposit:");
		System.out.println("2] Withdrawal:");
		System.out.println("Choose Action:");
		int action = scanner.nextInt();
		
		switch (action) {
		case 1: 
			
			DatabaseManager db = new DatabaseManager();
			db.deposit();
			
			
			CustomerMenuAfterLogin custMenu = new CustomerMenuAfterLogin ("Account Holder Menu");
			custMenu.displayMenuAndCaptureSelection();
			break;
			
		case 2:
			
			DatabaseManager data  = new DatabaseManager();
			data.withdrwal();
			
			CustomerMenuAfterLogin custMenu1 = new CustomerMenuAfterLogin ("Account Holder Menu");
			custMenu1.displayMenuAndCaptureSelection();
			break;
			
		}
	}
}


