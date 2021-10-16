package com.revature.app.codingSession;

import java.util.Scanner;

public class CodeDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = scan.nextInt();
		
		for( int i=1; i<=10; i++) {
			System.out.println(number + " * "+i+ " =  "+ number*i);
		}
	}

}
