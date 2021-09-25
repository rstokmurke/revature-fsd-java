package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.EmployeeDao;

class EmployeeDaoImplTest {

	@Test
	void testList_Success() {
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			assertTrue(dao.list().size() > 0);
		} catch (SQLException e) {
			fail("Getting employee list failed");
		}
	}

}
