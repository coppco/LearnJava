package com.github.regex;

public class Demo2_Regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/** [abc] : a、b或者c
		* [^abc] : 任意字符除了a、b或c
		* [a-zA-Z] : a到z或A到Z
		* [a-d[m-p]] : a到d或m到p
		* [a-z&&[def]] : d、e和f(交集)
		* [a-z&&[^bc]] : a到z除了b、c(交集)
		* [a-z&&[^m-p]] : a到z,并且非m到p(交集)*/
		
		int a = Integer.parseInt("asf");
		System.out.println(a);
	}

}
