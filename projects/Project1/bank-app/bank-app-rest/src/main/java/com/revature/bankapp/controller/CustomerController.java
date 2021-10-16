package com.revature.bankapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

@Path("/customers")
public class CustomerController {
	@Context
	private HttpServletRequest httpServletRequest;
	private static Customer currentCustomer;
	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void setCurrentCustomer(Customer currentCustomer) {
		CustomerController.currentCustomer = currentCustomer;
	}

	private HttpServletResponse httpServletResponse;
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private CustomerDao dao = new CustomerDaoImpl();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Customer customer) {
		LOGGER.info("Start");
		LOGGER.debug("{}", customer);
		try {
			dao.create(customer);
			LOGGER.info("End");
			return Response.ok().build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("email") String email, @PathParam("password") String password, @Context HttpServletRequest request) {
		LOGGER.info("Start");
		Customer customer = null;
		try {
			customer = dao.getCustomerByEmail(email);
			System.out.println("customer = " + customer);
			if (customer == null) {
				LOGGER.info("Invalid Password or Email");
				return Response.status(401).build();
			} else if (customer.getPassword().equals(password)) {

				LOGGER.info("Login Successful");
				LOGGER.debug("{}", customer);
				CustomerController.setCurrentCustomer(customer);
				request.getSession().setAttribute("customer", customer);
				LOGGER.debug("{}",request.getSession().getId());
				//System.out.println(httpServletRequest.getSession().getAttribute("customer"));
//				
//				try {
//					httpServletResponse.getWriter().write("Session Working");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				return Response.ok().build();

			} else {
				LOGGER.info("Invalid Password or Email");
				return Response.status(401).build();
			}

		} catch (AppException e) {
			return Response.status(500).build();
		}

	}
	
}
