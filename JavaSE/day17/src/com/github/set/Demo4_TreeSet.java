package com.github.set;

import java.util.Comparator;
import java.util.TreeSet;

import com.github.model.Person;

public class Demo4_TreeSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TreeSet
		
		TreeSet<Person> ts = new TreeSet<>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return (o1.getName().compareTo(o2.getName()));
			}
			@Override
			public boolean equals(Object obj) {
				
				return super.equals(obj);
			}
		});
		
		ts.add(new Person("aa", 24));
		ts.add(new Person("张三", 24));
		ts.add(new Person("张三", 24));
		ts.add(new Person("李四", 24));
		ts.add(new Person("b四", 24));
		ts.add(new Person("王五", 24));
		ts.add(new Person("啊啊", 24));
		
		for (Person person : ts) {
			System.out.println(person);
		}
	}

}
