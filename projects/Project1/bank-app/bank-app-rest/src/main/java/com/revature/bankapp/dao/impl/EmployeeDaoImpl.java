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
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

public class EmployeeDaoImpl implements EmployeeDao {

//	@Override
//	public List<Employee> list() throws SQLException {
//		List<Employee> accountList = new ArrayList<>();
//		try (Connection connection = Util.getConnection()) {
//
//			String sql ="select c.firstname, c.lastname, a.accountNo, a.balance, a.status, a.customerid \r\n" + 
//					"from customer c \r\n" + 
//					"inner join account a  \r\n" + 
//					"on c.id = a.customerid";
//				//	+ " where a.status ='N';";
//				
//			PreparedStatement statement = connection.prepareStatement(sql);
//			//statement.setInt(1,CustomerDaoImpl.currentCustomerId);
//			ResultSet resultset = statement.executeQuery();
//			while (resultset.next()) {
//
//				Employee account = new Employee("dd","ff","rr", 05,'f',1);
//				//account.setId(resultset.getInt("id"));
//				account.setFirstname(resultset.getString("firstname"));
//				account.setLastname(resultset.getString("lastname"));
//				account.setAccountNo(resultset.getString("accountNo"));
//				account.setBalance(resultset.getDouble("balance"));
//				account.setStatus(resultset.getString("status").charAt(0));
//				account.setCustomerid(resultset.getInt("customerid"));
//				
//				/*Department department = new Department();
//				department.setId(resultset.getInt("d.id"));
//				department.setName(resultset.getString("d.name"));
//				employee.setDepartment(department);*/
//				
//				accountList.add(account);
//			}
//			accountList.forEach(System.out::println);
//		}
//		return accountList;
//	}
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
	
//	public void showTransactionsListforemployee() {
//		TransactionDaoImpl transactionDaoImpl = new TransactionDaoImpl();
//		Scanner scann = new Scanner(System.in);
//		System.out.print("Customer Id : ");
//		int customer_id = scann.nextInt();
//		try {
//			ArrayList<Transaction> transactionList = (ArrayList<Transaction>) transactionDaoImpl
//					.showTransactions(customer_id);
//			transactionList.forEach(System.out::println);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	@Override
	public List<Account> showCustomerList() throws AppException {
		List<Account> custList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
//			String sql = "select c.id ,c.firstname, c.lastname, a.id , a.balance from customer c inner join account a where c.id = a.customerid";
			String sql = "SELECT * FROM account";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Account account = new Account();
				
				account.setId(rs.getInt("accountNo"));
				account.setBalance(rs.getInt("balance"));

				custList.add(account);

			}
		}catch(SQLException e) {
			
			throw new AppException(e);
		}
		return custList;
	}
	@Override
	public List<Transaction> showTransList(long accountId) throws AppException {
		List<Transaction> transList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select id, type, ammount from transaction where account_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) accountId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("id"));
				transaction.setType(rs.getString("type"));
				transaction.setAmount(rs.getInt("ammount"));

				transList.add(transaction);
			}
		}catch(SQLException e) {
			throw new AppException(e);
		}
		return transList;
	}

	@Override
	public List<Employee> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
