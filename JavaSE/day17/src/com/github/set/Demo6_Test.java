package com.github.set;

import java.util.Arrays;
import java.util.Scanner;

public class Demo6_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��������, Ȼ������
		
		System.out.println("�������ַ���");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String st = sc.nextLine();
			char[] array = st.toCharArray();
			Arrays.sort(array);
			System.out.println(array);
		}
	}

}
