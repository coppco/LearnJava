package com.coppco.stringBuffer;

public class Demo2_StringToStringBuffer {
	
	public static void main(String[] args) {
		/*
		 * String to StringBuffer
		 */
		
		//1 ���췽��
		StringBuffer sb = new StringBuffer("coppco");
		System.out.println(sb);
		
		//2 append����
		StringBuffer sb1 = new StringBuffer();
		sb1.append("coppco");
		System.out.println(sb1);
	}
	
}