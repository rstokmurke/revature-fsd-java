package com.revature.bankapp.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;

public class DatabaseManager {

	public static void withdrwal() {
		System.out.println("Enter amount to withdraw");
		Scanner sc = new Scanner(System.in);
		long amount = sc.nextLong();
		int accountNo = CustomerDaoImpl.currentCustomerId;
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		double currentBalance = 0;
		try {
			currentBalance = transactionDaoImpl.showBalance(accountNo);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (currentBalance >= amount) {
			try {
				transactionDaoImpl.performWithdrawl(accountNo, currentBalance - amount);
				System.out.println("Rs." + amount + " withdrawn..");
				transactionDaoImpl.addTransaction(accountNo, "Withdrwal", amount);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (amount < 0) {
			System.out.println("Enter Valid Amount");
		} else {
			System.out.println("Insufficient Funds");
		}

	}

	public static void deposit() {
		System.out.print("Enter amount to deposit : ");
		Scanner sc = new Scanner(System.in);
		long amount = sc.nextLong();
		int accountNo = CustomerDaoImpl.currentCustomerId;
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		double currentBalance = 0;

		try {
			currentBalance = transactionDaoImpl.showBalance(accountNo);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (amount > 0) {
			try {
				transactionDaoImpl.performDeposit(accountNo, currentBalance + amount);
				System.out.println("Rs." + amount + " deposited..");
				transactionDaoImpl.addTransaction(accountNo, "Deposit", amount);
			} catch (SQLException e) {

				e.printStackTrace();

				System.out.println("Rs." + amount + " deposited..");
			}
		} else {
			System.out.println("Enter valid amount");
		}
	}
	
	public static void showTransactionsList() {
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		int accountNo = CustomerDaoImpl.currentCustomerId;

		try {
			ArrayList<Transaction> transactionList = (ArrayList<Transaction>) transactionDaoImpl
					.showTransactions(accountNo);
			transactionList.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter recepient account Id:");
		int toAccountId = sc.nextInt();
		System.out.println("Enter Amount to transafer:");
		int amount = sc.nextInt();
		int fromAccountId = CustomerDaoImpl.currentCustomerId;

		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		double currentBalanceOfFromAccount = 0;
		double currentBalanceOfToAccount = 0;

		try {
			currentBalanceOfFromAccount = transactionDaoImpl.showBalance(fromAccountId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			currentBalanceOfToAccount = transactionDaoImpl.showBalance(toAccountId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (amount <= 0) {
			System.out.println("Enter Valid amount ");
		} else if (amount >= 0 && currentBalanceOfFromAccount >= amount) {
			try {
				transactionDaoImpl.performDeposit(toAccountId, currentBalanceOfToAccount + amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				transactionDaoImpl.performWithdrawl(fromAccountId, currentBalanceOfFromAccount - amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				transactionDaoImpl.addTransaction(fromAccountId, "Transafer to Account No" + toAccountId, amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Transfered successfuly.");
		} else {
			System.out.println("enter valid amount");
		}

	}
}
