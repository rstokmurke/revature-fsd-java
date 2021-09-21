package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Employee;

class EmployeeImplDaoTest {

	@Test
	void test() {
		EmployeeDaoImpl accountdao = new EmployeeDaoImpl();
		Employee employee = new Employee("dd","ff","rr", 05,'e');
		try {
			accountdao.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
