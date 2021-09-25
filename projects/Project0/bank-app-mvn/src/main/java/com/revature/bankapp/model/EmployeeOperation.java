package com.revature.bankapp.model;

import java.sql.SQLException;
import java.util.Scanner;
import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.menu.EmployeeMenu;

public class EmployeeOperation {

	public static void main(String args[]) {
		try {
			EmployeeOperation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void EmployeeOperation() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("1] Enter Customer_Id to Approve Account:");
		System.out.println("2] Enter Customer_Id to Reject Account:");
		System.out.println("3] Enter Customer_Id to view Transactions:");
		System.out.println("4] Previous Menu:");
		System.out.println("Choose Action:");
		int action = scanner.nextInt();

		switch (action) {

		case 1:
			// System.out.println("Enter Customer Id");
			// int sc=scanner.nextInt();
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
			Scanner sc = new Scanner(System.in);
			System.out.print("Customer Id : ");
			int account_id = sc.nextInt();
			try {
				employeeDaoImpl.approveAccount(account_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Status changes to approved");
			EmployeeMenu emenu = new EmployeeMenu("Employee Menu");
			emenu.displayMenuAndCaptureSelection();

			break;

		case 2:
			EmployeeDaoImpl employeeDaoImp = new EmployeeDaoImpl();
			Scanner scan = new Scanner(System.in);
			System.out.print("Customer Id : ");
			int account = scan.nextInt();
			try {
				employeeDaoImp.rejectAccount(account);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Status changes to rejected");
			EmployeeMenu emenuu = new EmployeeMenu("Employee Menu");
			emenuu.displayMenuAndCaptureSelection();
			break;
		case 3:
			EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
			employeeDao.showTransactionsListforemployee();
			EmployeeMenu menu = new EmployeeMenu("Employee Menu");
			menu.displayMenuAndCaptureSelection();
			break;
		case 4:
			EmployeeMenu emen = new EmployeeMenu("Employee Menu");
			emen.displayMenuAndCaptureSelection();
			break;
		}
	}
}
