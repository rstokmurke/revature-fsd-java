package com.revature.bankapp.main;

import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Customer;

public class Bankapp {

	public static Customer currentCustomer;
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu ("Main Menu");
		menu.displayMenuAndCaptureSelection();
	}
	public static Customer getCurrentCustomer() {
		return currentCustomer;
}
	public static void setCurrentCustomer(Customer customer) {
		currentCustomer = customer;
	}
}