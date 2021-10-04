package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> list() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {

			String sql = "select accountNo, balance\r\n" + 
					"from account where customerid = ? " ;
				
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,CustomerDaoImpl.currentCustomerId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {

				Account account = new Account(sql, 0);
				//account.setId(resultset.getInt("id"));
				account.setAccountNo(resultset.getString("accountNo"));
				account.setBalance(resultset.getDouble("balance"));
				//statement.setInt(1,CustomerDaoImpl.currentCustomerId);
				//account.setCustomerid(resultset.getInt("customerid"));
				
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
	public Customer getCustomerByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
		public void create(Account account) throws SQLException {

			try (Connection connection = Util.getConnection()) {
				String sql = "insert into account (accountNo, balance, customerid, status) values (?, ?, ?, 'N')";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, account.getAccountNo());
				statement.setDouble(2, account.getBalance());
				statement.setInt(3, CustomerDaoImpl.currentCustomerId);
				//statement.setString(4, customer.getPassword());
				
				
				statement.executeUpdate();
			}
		
	}
	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer employee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account account) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performDeposit(String accountNo, String balance) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public Object currentAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performDeposit(String balance) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
