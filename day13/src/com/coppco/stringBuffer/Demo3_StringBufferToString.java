package com.coppco.stringBuffer;

public class Demo3_StringBufferToString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * StringBuffer ----> String
		 */
		//1 构造方法
		StringBuffer sb = new StringBuffer("coppco");
		String s1 = new String(sb);
		System.out.println(s1);
		
		//2 toString()方法
		String s2 = sb.toString();
		System.out.println(s2);
		
		//通过substring()方法
		String s3 = sb.substring(0);
		System.out.println(s3);
		
	}

}
