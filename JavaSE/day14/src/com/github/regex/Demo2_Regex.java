package com.github.regex;

public class Demo2_Regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/** [abc] : a��b����c
		* [^abc] : �����ַ�����a��b��c
		* [a-zA-Z] : a��z��A��Z
		* [a-d[m-p]] : a��d��m��p
		* [a-z&&[def]] : d��e��f(����)
		* [a-z&&[^bc]] : a��z����b��c(����)
		* [a-z&&[^m-p]] : a��z,���ҷ�m��p(����)*/
		
		int a = Integer.parseInt("asf");
		System.out.println(a);
	}

}
