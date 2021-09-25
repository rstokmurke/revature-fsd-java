package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

class AccountDaoImplTest {

	@Test
	void testList_success() {
		AccountDaoImpl accountdao = new AccountDaoImpl();
		try {
			assertTrue(accountdao.list().size() >= 0);
		} catch (SQLException e) {
			fail("Getting employee list failed");
		}
	}

}
