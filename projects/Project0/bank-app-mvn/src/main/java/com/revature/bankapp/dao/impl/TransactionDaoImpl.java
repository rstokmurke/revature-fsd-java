package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Transaction;
public class TransactionDaoImpl implements TransactionDao {

	@Override
	public void performWithdrawl(int accountId, double money) throws SQLException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) money);
			preparedStatement.setInt(2, (int) accountId);
			preparedStatement.executeUpdate();
			
			connection.close();

		}
		
	}

	@Override
	public void performDeposit(int accountId, double money) throws SQLException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) money);
			preparedStatement.setInt(2, (int) accountId);
			preparedStatement.executeUpdate();
			
			connection.close();

		}
		
	}

	@Override
	public double showBalance(int accountId) throws SQLException {
		double balanceReturned = 0;
		try (Connection connection = Util.getConnection()) {

			String sql = "select balance from account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,(int)accountId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				balanceReturned = (double) rs.getInt("balance");
			}

		}
		return balanceReturned;
	}

	@Override
	public void addTransaction(long accountId, String type, long money) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transaction> showTransactions(long accountId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
