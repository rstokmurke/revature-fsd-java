package com.revature.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.revature.app.collection.Person;

public class PredicateDemo {

	public static void main(String[] args) {
		Person person1 = new Person(1, "John", 15);
		Person person2 = new Person(2, "Smith", 25);
		Person person3 = new Person(3, "Stella", 32);
		Person person4 = new Person(4, "Maria", 42);
		Person person5 = new Person(5, "Janet", 42);
		
		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		
		// Create a new list that contains person who can vote. Age limit is 18.
		List<Person> votingEligiblePersonList = new ArrayList<>();
		for (Person person : personList) {
			if (person.getId() == 3) {
				votingEligiblePersonList.add(person);
			}
		}
		votingEligiblePersonList.forEach(System.out::println);
		
		System.out.println("\nData filtered using stream api:");
		List<Person> eligiblePersonList = personList.stream()
				.filter(p -> p.getId() == 3).collect(Collectors.toList());
	
		
		// Person person = stream api
		eligiblePersonList.forEach(System.out::println);
	}

}
