package com.github.object;

import com.github.eclipse.Student;

public class Demo_Equals {

	/**
	 * @param args
	 * equals �ж����������Ƿ����
	 */
	public static void main(String[] args) {
		Student s1 = new Student("����", 12);
		Student s2 = new Student("����", 123);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s1));
		System.out.println(s2.equals(s2));
	}

}
