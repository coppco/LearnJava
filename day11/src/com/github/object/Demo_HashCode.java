package com.github.object;

import com.github.eclipse.Student;

public class Demo_HashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object object = new Object();
		int hashCode = object.hashCode();
		System.out.println(hashCode);
		
		Student student = new Student("уехЩ", 24);
		int stHashCode = student.hashCode();
		System.out.println(stHashCode);
		System.out.println(stHashCode);
	}

}
