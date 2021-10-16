package com.revature.app.codingSession;

import java.util.Scanner;

public class StringSplit {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the String");
		String s = scan.nextLine();
		
		String [] arr = s.split(" ");
		for (String i : arr) 
			System.out.println(i);
	}

}
