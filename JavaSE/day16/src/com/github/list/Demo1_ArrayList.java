package com.github.list;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo1_ArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//È¥³ıÖØ¸´
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("d");
		list.add("d");
		
		ArrayList newList = new ArrayList();
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			if (!newList.contains(object)) {
				newList.add(object);
			}
		}
		
		System.out.println(newList);
		
	}

}
