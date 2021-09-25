package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Employee;

public interface EmployeeDao {
	
	List<Employee> list() throws SQLException;

	void approveAccount(int customerid) throws SQLException;

	void rejectAccount(int customerid) throws SQLException;
}
