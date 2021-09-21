package com.revature.bankapp.dao.impl;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;


import com.revature.bankapp.model.Customer;

class CustomerDaoImplTest {

	@Test
	void test() {
		CustomerDaoImpl dao = new CustomerDaoImpl();
		Customer customer = new Customer("n","e","ss","ee");
		try {
			dao.create(customer);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	}
