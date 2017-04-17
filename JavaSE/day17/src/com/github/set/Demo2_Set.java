package com.github.set;

import java.util.HashSet;
import java.util.Random;

public class Demo2_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		Random random = new Random();
		while (hs.size() < 10) {
			hs.add(random.nextInt(20) + 1);
		}
		
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}

}
