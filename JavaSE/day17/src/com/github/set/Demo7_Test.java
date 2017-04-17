package com.github.set;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Demo7_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int result = o1.compareTo(o2);
				return result == 0 ? 1 : result;
			}
		});
		System.out.println("������һ������, quit��������");
		while (sc.hasNextLine()) {
			String num = sc.nextLine();
			if ("quit".equals(num)) {
				break;
			}
			Integer i = Integer.parseInt(num);
			ts.add(i);
		}
		for (Integer integer : ts) {
			System.out.println(integer);
		}
	}

}
