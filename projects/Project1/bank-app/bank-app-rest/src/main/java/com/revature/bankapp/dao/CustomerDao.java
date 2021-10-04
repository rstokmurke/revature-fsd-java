package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;;

public interface CustomerDao {
	List<Customer> list() throws SQLException;
	Customer getCustomerByEmail(String email) throws SQLException;
	void create(Customer customer) throws AppException;
	void update(Customer employee) throws SQLException;
	void delete(int id) throws SQLException;
}
