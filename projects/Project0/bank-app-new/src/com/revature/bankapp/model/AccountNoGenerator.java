package com.revature.bankapp.model;

public class AccountNoGenerator {

	public static void main( String args[] )   
	{  
		AccountNoGenerator ();
	}
	public static int AccountNoGenerator() {
		
		int min = 100000;  
		int max = 999999;  
		//System.out.println("Your Account number is: ");  
		int accountNumber = (int)(Math.random()*(max-min+1)+min);  
		return accountNumber;  
	}  
	}  

