package com.github.set;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Demo3_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashSet<Character> hs = new LinkedHashSet<>();
		while (true) {
			System.out.println("ÇëÊäÈë×Ö·û´®");
			if (sc.hasNextLine()) {
				char[] st = sc.nextLine().toCharArray();
				hs.clear();
				for (char c : st) {
					hs.add(c);
				}
			}
			
			System.out.println(hs);	
		}
	}

}
