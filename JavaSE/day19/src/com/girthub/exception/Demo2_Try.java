package com.girthub.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Demo2_Try {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		try {
			int x =10 / 0;
			int[] arr = {1};
			arr[10] = 10;
			arr = null;
			arr[0] = 10;
		} catch (ArithmeticException e) {
			System.out.println(e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("×îºó");
		}
		
		FileInputStream file = new FileInputStream("xx");
		
	}

}
