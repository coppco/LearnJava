package com.github.collection;

import com.github.coppco.Student;

public class Demo1_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student[] arr = new Student[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Student(i + "", i + 20);
			System.out.println(arr[i]);
		}
		arr[6] = new Student();
		arr = null;
	}

}
