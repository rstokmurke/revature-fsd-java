package com.revature.app.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ListDemo {

	public static void main(String[] args) {
		Integer age = new Integer(10);
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(78);
		arrayList.add(90);
		arrayList.add(34);
		arrayList.add(32);
		arrayList.add(58);
		arrayList.add(21);
		
		for (Integer number : arrayList) {
			System.out.println(number);
		}
		System.out.println("\nusing indexing");
		arrayList.set(1,95);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println("\nSorted");
		Collections.sort(arrayList);
		for (Integer number : arrayList) {
			System.out.println(number);
		
	}

}
}