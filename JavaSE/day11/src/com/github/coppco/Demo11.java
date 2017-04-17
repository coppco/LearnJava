package com.github.coppco;

import com.github.Animal.Cat;
import com.github.eclipse.Student;

public class Demo12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student student = new Student("уехЩ", 19);
		System.out.println(student.getName());
		
		Cat cat = new Cat();
		cat.eat();
		
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}
