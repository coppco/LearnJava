package com.github.set;

import java.util.Arrays;
import java.util.Scanner;

public class Demo6_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//¼üÅÌÊäÈë, È»ºóÅÅĞò
		
		System.out.println("ÇëÊäÈë×Ö·û´®");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String st = sc.nextLine();
			char[] array = st.toCharArray();
			Arrays.sort(array);
			System.out.println(array);
		}
	}

}
