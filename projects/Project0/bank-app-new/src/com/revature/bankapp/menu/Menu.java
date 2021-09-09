package com.revature.bankapp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
	protected String name;
	protected List<String> menuItems;
	protected int selection;

	public Menu(String name) {
		this.name = name;
		menuItems = new ArrayList<>();		
	}
	
	public void addMenuItem(String menuItemName) {
		menuItems.add(menuItemName);
	}
	
	public void displayMenu() {
		System.out.println("*********");
		System.out.println(name);
		System.out.println("*********");
		for (int i = 0; i< menuItems.size(); i++) {
			System.out.println((i + 1) + "]" + menuItems.get(i));
		}
		System.out.print("Choose the option :");
	} 
	
	public void captureSelection() {
		Scanner scanner = new Scanner(System.in);
		selection = Integer.parseInt(scanner.nextLine());
		handleAction();
	}
	public void displayMenuAndCaptureSelection() {
		displayMenu();
		captureSelection();
		
	}
	abstract void handleAction();
	
}
