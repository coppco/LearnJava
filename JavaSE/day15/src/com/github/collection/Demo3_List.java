package com.github.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Demo3_List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//error();
		
//		diedaiqichuli();
		
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			System.out.println(o);
			if (o.equals(2)) {
				list.add(100);				
			}
			
		}
		System.out.println(list);
	}

	public static void diedaiqichuli() {
		List l1 = new ArrayList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		ListIterator it = l1.listIterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
			if (o.equals(2)) {
				it.add("a");
			}
		}
		System.out.println(l1);
	}

	public static void error() {
		List list = new ArrayList();
		list.add(10);
		list.add(11);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			list.add("a");
		}
	}

}
