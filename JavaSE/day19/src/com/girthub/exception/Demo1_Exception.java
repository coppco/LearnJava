package com.girthub.exception;

public class Demo1_Exception {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] arr1 = {1,2,3,4,5};
		arr= null;
		System.out.println(arr1[10]); //“Ï≥£
		System.out.println(arr[1]); //“Ï≥£
	}

}
