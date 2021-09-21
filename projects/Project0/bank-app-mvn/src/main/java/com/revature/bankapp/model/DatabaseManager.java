package com.revature.bankapp.model;

import java.sql.SQLException;
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (currentBalance >= amount) {
			try {
				transactionDaoImpl.performWithdrawl(accountNo, currentBalance - amount);
				System.out.println("Rs."+ amount+" withdrawn..");
				//transactionDaoImpl.addTransaction(accountNo, "Withdrwal", amount);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				//System.out.println("Rs."+ amount+" withdrawn..");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (amount > 0) {
			try {
				transactionDaoImpl.performDeposit(accountNo, currentBalance + amount);
				System.out.println("Rs."+ amount+" deposited..");
				//transactionDaoImpl.addTransaction(accountNo, "Deposit", amount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("Rs."+ amount+" deposited..");
			}
		} else {
			System.out.println("Enter valid amount");
		}
	}
}
