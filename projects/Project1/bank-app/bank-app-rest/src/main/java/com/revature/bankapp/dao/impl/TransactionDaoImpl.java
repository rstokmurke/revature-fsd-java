package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;
public class TransactionDaoImpl implements TransactionDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionDaoImpl.class);

	@Override
	public void performWithdrawl(int accountId, double money) throws AppException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where accountNo = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) money);
			preparedStatement.setInt(2, (int) accountId);
			preparedStatement.executeUpdate();
			
			connection.close();

		}catch (SQLException e) {
			LOGGER.error("withdraw perform fails",e);
			throw new AppException(e);
		}
		
	}

	@Override
	public void performDeposit(int accountId, double money) throws AppException {
		try (Connection connection = Util.getConnection()) {

			String sql = "update bankapp.account set balance = ? where accountNo = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) money);
			preparedStatement.setInt(2, (int) accountId);
			preparedStatement.executeUpdate();
			
			connection.close();

		} catch (SQLException e) {
			LOGGER.error("deposit perform fail",e);
			throw new AppException(e);
		}
		
	}

	@Override
	public double showBalance(int accountId) throws AppException {
		double balanceReturned = 0;
		try (Connection connection = Util.getConnection()) {

			String sql = "select balance from account where accountNo = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,(int)accountId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				balanceReturned = (double) rs.getInt("balance");
			}
		}
			catch (SQLException e) {
				LOGGER.error("Getting Customer Details",e);
				throw new AppException(e);
			}

		return balanceReturned;
	}

	@Override
	public void addTransaction(int accountId, String type, double amount) throws AppException {
		try(Connection connection = Util.getConnection()){
			
			String sql = "INSERT INTO transaction (type, ammount, account_id) VALUES (?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, (int) amount);
			preparedStatement.setInt(3, (int) accountId);
			
			preparedStatement.executeUpdate();
			connection.close();
			
		}catch (SQLException e) {
			LOGGER.error("performing deposit failed",e);
			throw new AppException(e);
		}
		
	}

	@Override
	public List<Transaction> showTransactions(int accountId) throws AppException {
		List<Transaction> transactionList = new ArrayList<>();
		
		
		try(Connection connection = Util.getConnection()){
			
			String sql = "select id, type, ammount from transaction where account_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (int) accountId);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("id"));
				transaction.setType(rs.getString("type"));
				transaction.setAmount(rs.getDouble("ammount"));
				
				transactionList.add(transaction);
			}
		}catch (SQLException e) {
			LOGGER.error("Getting transactions failed",e);
			throw new AppException(e);
		}
		
		return transactionList;
	}
}
