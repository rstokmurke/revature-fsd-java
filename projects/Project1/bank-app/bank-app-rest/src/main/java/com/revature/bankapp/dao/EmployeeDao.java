package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

public interface EmployeeDao {
	
	public List<Account>  showCustomerList() throws AppException;
	public List<Transaction> showTransList(long accountId) throws AppException;
	List<Employee> list() throws SQLException;

	void approveAccount(int customerid) throws SQLException;

	void rejectAccount(int customerid) throws SQLException;
}
