package com.revature.bankapp.model;

import java.util.Scanner;

import com.revature.bankapp.menu.CustomerMenuAfterLogin;

public class AccountManager {

	public static void main(String args[]) {
		AccountManager();
	}

	public static void AccountManager() {

		AccountNoGenerator accountNumber = new AccountNoGenerator();
		int acc = accountNumber.AccountNoGenerator();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Initial Balance:");
		double balance = scanner.nextDouble();
		
		System.out.println("1] Deposit:");
		System.out.println("2] Withdrawal:");
		System.out.println("Choose Action:");
		int action = scanner.nextInt();
		
		switch (action) {
		case 1: 
			System.out.println("Enter ammount");
			double depAmmount = scanner.nextDouble();
			System.out.println("Rs."+ depAmmount + " Deposited.. ");
			CustomerMenuAfterLogin custMenu = new CustomerMenuAfterLogin ("Account Holder Menu");
			custMenu.displayMenuAndCaptureSelection();
			break;
			
		case 2:
			System.out.println("Enter ammount");
			double widAmmount = scanner.nextDouble();
			System.out.println("Rs."+ widAmmount + " Withdhrawn.. ");
			CustomerMenuAfterLogin custMenu1 = new CustomerMenuAfterLogin ("Account Holder Menu");
			custMenu1.displayMenuAndCaptureSelection();
			break;
			
		}
	}
}

		// String accountNumber = "01302343794";
		// double balance = 5000.0;

		/*System.out.println("Account Statement of " + acc);
		System.out.println("Initial Balance " + balance);

		System.out.println("\n---------------------------");
		System.out.println("Type  Transactions  Balance");
		System.out.println("---------------------------");

		balance = calculateBalanceAndPrint('W', 2000.0, balance);
		/*
		  balance = calculateBalanceAndPrint('D', 20000.0, balance); balance =
		  calculateBalanceAndPrint('D', 500.0, balance); balance =
		  calculateBalanceAndPrint('W', 15500.0, balance); balance =
		  calculateBalanceAndPrint('W', 10000.0, balance);

		System.out.println("---------------------------");
	}

	public static double calculateBalanceAndPrint(char type, double transaction, double balance) {
		if (type == 'D') {
			balance += transaction;
		}
		if (type == 'W') {
			balance -= transaction;
		}

		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);
		return balance;
	}
}*/
