package com.github.string;

import com.github.bean.Person;

public class Demo2_Method {
	public static void main(String[] args) {
//		Demo1();
		
//		Demo2();
		
//		Demo3();
		
//		Demo4();
		
//		Demo5();
		
//		Demo6();
//		demo7();
		
		
//		Demo8();
		
		A a = new B();
		if (a instanceof B) {
			System.out.println(true);
		}
	}

	public static void Demo8() {
		String first = "coppcodsfjdsljsdllcoppcodsfsdl654454coppco,dslfjdslcoppco";
		int index = first.indexOf("coppco");
		int count = 0;
		while (index != -1) {
			count++;
			first = first.substring(index + "coppco".length());
			index = first.indexOf("coppco");
		}
		System.out.println("总共有:" + count + "个");
	}

	public static void demo7() {
		int[] arr = {1,2,3};
		String str = "\"[";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				str = str + arr[i] + "]\"";			
			} else {
				str = str + arr[i] + ",";
			}
		}
		System.out.println(str);
	}

	public static void Demo6() {
		String s = "sdfaDDDdsfldslflLLJLJLJFdsfldj";
		String s1 = s.substring(0, 1).toUpperCase().concat(s.substring(1).toLowerCase());
		System.out.println(s1);
	}

	public static void Demo5() {
		String s1 = "我的博客是: coppoc.github.io";
		String s2 = s1.toUpperCase();
		System.out.println(s2);
		String s3 = s2.toLowerCase();
		System.out.println(s3);
		String s4 = s3.concat(", 哈哈!");
		System.out.println(s4);
	}

	public static void Demo4() {
		Person person = new Person("张三", 24);
		String s1 = String.valueOf(person);
		System.out.println(s1);
	}

	public static void Demo3() {
		char[] arr = {'1','b','c',97};
		
		String str = String.valueOf(arr);
		System.out.println(str);
		
		String str1 = new String(arr);
		System.out.println(str1);
		
		String str2 = String.valueOf(100);
		System.out.println(str2);
	}

	private static void Demo2() {
		String str = "coppco";
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void Demo1() {
		String s1 = "coppco";
		byte[] arr = s1.getBytes();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		s1 = "中文试试, 中文可以吗琲";
		arr = s1.getBytes();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	
	
}

class A {
	
}

class B extends A {
	
}

abstract class C {
	int a = 10;
}
