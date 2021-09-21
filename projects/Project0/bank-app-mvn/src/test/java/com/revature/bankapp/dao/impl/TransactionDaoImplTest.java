package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.model.Transaction;

class TransactionDaoImplTest {

	@Test
	void test() {
		TransactionDaoImpl dao = new TransactionDaoImpl();
		Transaction transaction = new Transaction();
		try {
			dao.performDeposit(22, 11);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	fail("Not yet implemented");
	}

}
