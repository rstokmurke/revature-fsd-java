package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

class TransactionDaoImplTest {

	@Test
	void test() {
		TransactionDaoImpl accountdao = new TransactionDaoImpl();
		try {
			accountdao.addTransaction(1, "deposit", 450);
			accountdao.showTransactions(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}


