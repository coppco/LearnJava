package com.github.set;

import java.util.HashSet;

import com.github.model.Person;

public class Demo1_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("����", 23));
		hs.add(new Person("����", 23));
		hs.add(new Person("����", 23));
		hs.add(new Person("����", 23));
		hs.add(new Person("����", 24));
		hs.add(new Person("����", 24));
		hs.add(new Person("����", 25));
		hs.add(new Person("����", 25));
		
		for (Person person : hs) {
			System.out.println(person);
		}
	}

}
