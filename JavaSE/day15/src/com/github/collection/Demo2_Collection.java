package com.github.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.github.coppco.Student;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Demo2_Collection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Collection
		//1. add
		
		Collection c = new ArrayList();
		c.add(new Student());
		c.add(1);
		System.out.println(c.contains(1));
		c.remove(1);
		System.out.println(c.contains(1));
		System.out.println(c.size());
		System.out.println(c);
		c.clear();
		System.out.println(c.size());
		
		c.add(new Student());
		c.add(1);
		c.add("eee");
		
		Object[] arr = c.toArray();
		for (int i = 0; i < arr.length; i++) {
			Object o = arr[i];
			System.out.println(o.getClass() + "  " + o);
			if (o instanceof Student) {
				Student s = (Student)o;
				System.out.println(s.getName());
			}
		}
		
		
		Collection dd = new ArrayList();
		dd.add(new Student("张三", 13));
		dd.add(new Student("李四", 23));
		dd.add(new Student("王五", 33));
		dd.add(new Student("熊二", 43));
		dd.add(new Student("熊大", 53));
		dd.add(1);
		Iterator it = dd.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof Student) {
				Student s = (Student)o;
				System.err.println(s.getName() + "  " + s.getAge());
			}
		}
		
	}

}
