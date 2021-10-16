package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	
	void performWithdrawl(int accountId, double money) throws AppException;
	void performDeposit(int accountId, double money) throws AppException;
	double showBalance(int accountId) throws AppException;
	void addTransaction(int accountId, String type, double amount) throws AppException;
	List<Transaction>showTransactions(int accountId) throws AppException;
}
