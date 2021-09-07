package com.revature.app.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int age = scanner.nextInt();
			System.out.println(age);
		} catch (InputMismatchException e) {
			System.out.println("Enter valid number"); // unchecked exception
		}
		System.out.println("After catch block");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			System.out.println(sdf.parse("01/01a/2021")); // checked exception
		} catch (ParseException e) {
			System.out.println("Enter date in dd/mm/yyyy format");
		}

	}

	public void methodThrowingException(int age) throws CustomException {
		if (age < 0) {
			throw new CustomException("Age cannot be negative.");

		}
		System.out.println("method processing...");
	}
}
