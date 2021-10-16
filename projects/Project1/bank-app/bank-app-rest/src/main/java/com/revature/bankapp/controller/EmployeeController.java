package com.revature.bankapp.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

@Path("/{employees}")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	EmployeeDao dao = new EmployeeDaoImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomersAccountList() {
		LOGGER.info("Calling customers called");
		try {
			ArrayList<Account> custList = (ArrayList<Account>) dao.showCustomerList();
			LOGGER.info("Showing Customers List successful");
			return Response.ok().entity(custList).build();
		} catch (AppException e) {
			LOGGER.info("Showing Customers failed");
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		
	}
	
	@GET
	@Path("/{accountId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountTransactionList(@PathParam("accountId") long accountId) {
		LOGGER.info("Account transaction listcalled for employee");
		try {
			ArrayList<Transaction> empTransList = (ArrayList<Transaction>) dao.showTransList(accountId);
			return Response.ok().entity(empTransList).build();
		} catch (AppException e) {
			LOGGER.info("Failed to show transacctions");
			e.printStackTrace();
			return Response.status(500).build();
		}
		
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response verifyLogin(Employee employee) {
		LOGGER.info("EmployeeLogn method called");
		LOGGER.debug("{}",employee);
		if(employee.getEmail().equals("user@gmail.com") && employee.getPassword().equals("password")) {
			LOGGER.info("Employee login successfull");
			return Response.ok().build();
			
		}else {
			LOGGER.info("AccessDenied invalid Password");
			return Response.status(401).build();
		}
	
	}

}
