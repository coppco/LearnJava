package com.github.list;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo2_E {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三", 24));
		list.add(new Person("李四", 24));
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			Person person = (Person) it.next();
			System.out.println(person.getName());
		}
		
	}

}

class Person<T> {
	private String name;
	private int age;

	public void show(T t) {
		System.out.println(t);
	}
	
	public<E> void hit(E e) {
		System.out.println(e);
	}
	
	public static<F> void sleep(F f) {
		
	}
	
}


interface Inter<T> {
	public abstract void show(T t);
}


class Student implements Inter<String> {

	@Override
	public void show(String t) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("d");
		Iterator<String> it = list.listIterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			if ("b".equals(string)) {
				it.remove();
			}
		}
		
	}
	
}