package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	private static List<Customer> customerList = new ArrayList<>();
	
	public static Customer currentCustomer;
	
	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public static Customer getCustomerByEmail(String email) {
		for (Customer customer : customerList) {
			if (customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	}
	
	public static void setcurrentCustomer(Customer customer) {
		currentCustomer = customer;
	}

	public static Customer currentCustomer() {
		return currentCustomer;
	}
}



