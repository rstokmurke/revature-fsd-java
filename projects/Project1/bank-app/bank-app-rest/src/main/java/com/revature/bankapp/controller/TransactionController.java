package com.revature.bankapp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

@Path("/transactions")
public class TransactionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	TransactionDao dao = new TransactionDaoImpl();

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response withdrawal(Transaction transaction) {
		long currentBalance = 0;
		LOGGER.info("Withdrwal method Start");
		LOGGER.debug("{}", transaction);
		try {
			currentBalance = (long) dao.showBalance(transaction.getId());
		} catch (AppException e) {
			LOGGER.info(" Performing withdrawal failed");
			e.printStackTrace();
			return Response.status(500).build();
		}
		if (currentBalance < transaction.getAmount()) {
			LOGGER.info("insufficient funds");
			return Response.status(400).build();
		} else {
			try {
				dao.performWithdrawl(transaction.getId(), currentBalance - transaction.getAmount());
				dao.addTransaction(transaction.getId(), "Withdrawal", transaction.getAmount());
				return Response.status(200).build();
			} catch (AppException e) {
				LOGGER.info(" Performing withdrawal failed");
				e.printStackTrace();
				return Response.status(500).build();
			}

		}
	}

	@PUT
	@Path("/deposit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deposit(Transaction transaction) {
		long currentBalance = 0;
		LOGGER.info("deposit method Start");
		LOGGER.debug("{}", transaction);
		try {
			currentBalance = (long) dao.showBalance(transaction.getId());
		} catch (AppException e) {
			LOGGER.info(" Performing Deposit failed");
			e.printStackTrace();
			return Response.status(500).build();
		}

		try {
			dao.performDeposit(transaction.getId(), currentBalance + transaction.getAmount());
			LOGGER.info("Deposit Successful");
			dao.addTransaction(transaction.getId(), "Deposit", transaction.getAmount());
			LOGGER.info("Adding transactions successfull");
			return Response.status(200).build();
		} catch (AppException e) {
			LOGGER.info(" Performing Deposit failed");
			e.printStackTrace();
			return Response.status(500).build();
		}

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactions(@PathParam("id") long id) {
		LOGGER.info("Transactions method called");
		LOGGER.debug("{}", id);
		try {
			List<Transaction> transactionList = dao.showTransactions((int) id);
			LOGGER.info("Transaction got successfuly");
			return Response.ok().entity(transactionList).build();
		} catch (AppException e) {
			LOGGER.info("Showing transactions failed");
			e.printStackTrace();
			return Response.status(500).build();
		}

	}
}
