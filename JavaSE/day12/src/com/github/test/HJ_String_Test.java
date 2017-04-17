package com.github.test;

public class HJ_String_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 1.×Ö·û´®µÄ±È½Ï
		 */
		
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 = "a" + "b" + "c";
		String s4 = "abc";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		String s5 = "def";
		String s6 = new String("def");
		System.out.println(s5 == s6);
		System.out.println(s5.equals(s6));
		
		String s7 = "12";
		String s8 = "123";
		String s9 = s7 + "3";
		System.out.println(s8 == s9);
		System.out.println(s8.equals(s9));
		
		
	}

}
