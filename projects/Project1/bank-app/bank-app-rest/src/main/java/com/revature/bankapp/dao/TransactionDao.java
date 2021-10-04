package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	
	void performWithdrawl(int accountId, double money) throws SQLException;
	void performDeposit(int accountId, double money) throws SQLException;
	double showBalance(int accountId) throws SQLException;
	void addTransaction(int accountId, String type, double amount) throws SQLException;
	List<Transaction>showTransactions(int accountId) throws SQLException;
}
