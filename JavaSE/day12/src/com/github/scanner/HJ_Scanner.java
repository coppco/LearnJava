package com.github.scanner;

import java.util.Scanner;

public class HJ_Scanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int number = (int) scanner.nextInt();
			System.out.println(number);
		}
	}

}