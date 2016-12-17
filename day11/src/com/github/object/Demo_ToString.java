package com.github.object;

import com.github.eclipse.Student;

public class Demo_ToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = new Student("ÀîËÄ", 57);
		System.out.println(s.toString());
		System.out.println(s);
	}

}
