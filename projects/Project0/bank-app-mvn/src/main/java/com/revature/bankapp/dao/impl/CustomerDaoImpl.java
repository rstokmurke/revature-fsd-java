package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public static int currentCustomerId;

	@Override
	public List<Customer> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByEmail(String email) throws SQLException {
		Customer customer = null;
			try (Connection connection = Util.getConnection()) {
				String sql = "SELECT * FROM bankapp.customer where email= ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, email);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					currentCustomerId = resultSet.getInt("id");
					String fn = resultSet.getString("firstname");
					String ln = resultSet.getString("lastname");
					String em = resultSet.getString("email");
					String psw = resultSet.getString("password");

					customer = new Customer(fn, ln, em, psw);
					
				}
			}
			return customer;
	}

	@Override
	public void create(Customer customer) throws SQLException {
		
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (firstname, lastname, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getFirstname());
			statement.setString(2, customer.getLastname());
			statement.setString(3, String.valueOf(customer.getEmail()));
			statement.setString(4, customer.getPassword());
			statement.executeUpdate();
		}
		
	}

	@Override
	public void update(Customer employee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
