package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> list() throws SQLException {
		List<Employee> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {

			String sql ="select c.firstname, c.lastname, a.accountNo, a.balance, a.status, a.customerid \r\n" + 
					"from customer c \r\n" + 
					"inner join account a  \r\n" + 
					"on c.id = a.customerid";
				//	+ " where a.status ='N';";
				
			PreparedStatement statement = connection.prepareStatement(sql);
			//statement.setInt(1,CustomerDaoImpl.currentCustomerId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {

				Employee account = new Employee("dd","ff","rr", 05,'f',1);
				//account.setId(resultset.getInt("id"));
				account.setFirstname(resultset.getString("firstname"));
				account.setLastname(resultset.getString("lastname"));
				account.setAccountNo(resultset.getString("accountNo"));
				account.setBalance(resultset.getDouble("balance"));
				account.setStatus(resultset.getString("status").charAt(0));
				account.setCustomerid(resultset.getInt("customerid"));
				
				/*Department department = new Department();
				department.setId(resultset.getInt("d.id"));
				department.setName(resultset.getString("d.name"));
				employee.setDepartment(department);*/
				
				accountList.add(account);
			}
			accountList.forEach(System.out::println);
		}
		return accountList;
	}
	@Override
	public void approveAccount(int customerid) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account  set status = 'A' where customerid= ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,customerid);
			preparedStatement.executeUpdate();

			connection.close();
		}

	}

	@Override
	public void rejectAccount(int customerid) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account  set status = 'R' where customerid= ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,customerid);
			preparedStatement.executeUpdate();

		}
	}
	
	public void showTransactionsListforemployee() {
		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
		Scanner scann = new Scanner(System.in);
		System.out.print("Customer Id : ");
		int customer_id = scann.nextInt();
		try {
			ArrayList<Transaction> transactionList = (ArrayList<Transaction>) transactionDaoImpl
					.showTransactions(customer_id);
			transactionList.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
