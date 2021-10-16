package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;


public interface AccountDao {
	
	public List<Account> list() throws AppException;
	Customer getCustomerByEmail(String email) throws SQLException;
	void update(Customer employee) throws SQLException;
	void delete(int id) throws SQLException;
	void create(Account account) throws AppException;
	void update(Account account) throws SQLException;
	void performDeposit(String accountNo, String balance) throws SQLException;
	void performDeposit(String balance) throws SQLException;
	
}
