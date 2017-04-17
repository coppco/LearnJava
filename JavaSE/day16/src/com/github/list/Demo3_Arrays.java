package com.github.list;

import java.util.Arrays;
import java.util.List;

public class Demo3_Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1,3,4,5,6};
		List<int[]> list = Arrays.asList(a);
		
		System.out.println(list);
		
		Integer[] b = {1,3,4,5,6};
		List<Integer> list1 = Arrays.asList(b);

		System.out.println(list1);
		System.out.println("--------------");
		
		Integer[] c = list1.toArray(new Integer[0]);
		System.out.println(c[0]);
	}

}
