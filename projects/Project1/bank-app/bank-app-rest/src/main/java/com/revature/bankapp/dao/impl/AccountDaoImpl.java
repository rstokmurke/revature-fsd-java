package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.controller.CustomerController;
import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

public class AccountDaoImpl implements AccountDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);
	@Override
	public List<Account> list() throws AppException {
		LOGGER.info("Show Accounts called");
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {

			String sql = "select accountNo, balance\r\n" + 
					"from account where customerid = ? " ;
				
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,(int) CustomerController.getCurrentCustomer().getId());
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
		}
			catch(SQLException e) {
				LOGGER.error("Getting Customer Details",e);
				throw new AppException(e);
				}
		return accountList;
	}


	@Override
	public Customer getCustomerByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
		public void create(Account account) throws AppException {

			try (Connection connection = Util.getConnection()) {
				String sql = "insert into account (accountNo, balance, customerid, status) values (?, ?, ?, 'A')";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, account.getAccountNo());
				statement.setDouble(2, account.getBalance());
				statement.setInt(3, account.getCustomerid());
				//statement.setString(4, customer.getPassword());
				
				
				statement.executeUpdate();
			}
			catch (SQLException e) {
				LOGGER.error("Inserting account details");
				throw new AppException(e);
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
