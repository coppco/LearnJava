package com.github.array;

public class Demo1_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {213, 45, 23, 1, 65, 121, 90};
		
		//maopao(arr);
		
		xuanzhe(arr);
		
		printArr(arr);
		
	}

	public static void xuanzhe(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j]= temp;
				}
			}
		}
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	//Ã°ÅÝÅÅÐò
	public static void maopao(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
