package com.github.object;

import com.github.eclipse.Student;

public class Demo_Equals {

	/**
	 * @param args
	 * equals 判断两个对象是否相等
	 */
	public static void main(String[] args) {
		Student s1 = new Student("张三", 12);
		Student s2 = new Student("张三", 123);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s1));
		System.out.println(s2.equals(s2));
	}

}
