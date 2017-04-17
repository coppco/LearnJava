package com.github.array;

import java.util.Arrays;

public class Demo2_Arrays {

	/**
	 * @param 
	 */
	public static void main(String[] args) {
		//01 toString
		int[] arr = {11,22,54,6,7,8};
		System.out.println(Arrays.toString(arr));
		
		//sort
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//binary
		
		System.out.println(Arrays.binarySearch(arr, 54));
		System.out.println(Arrays.binarySearch(arr, 88));
		System.out.println(Arrays.binarySearch(arr, -1));
	}

}
