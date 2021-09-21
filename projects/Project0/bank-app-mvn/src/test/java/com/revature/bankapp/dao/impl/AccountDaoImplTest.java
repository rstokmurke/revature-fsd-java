package com.revature.bankapp.dao.impl;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

class AccountDaoImplTest {

	@Test
	void test() {
		AccountDaoImpl accountdao = new AccountDaoImpl();
		Account account = new Account(null, 0);
		try {
			accountdao.create(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
