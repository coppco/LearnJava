package com.coppco.stringBuffer;

public class Demo1_StringBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		append();
		
//		insert();
//		delete();
		
//		replace();
//		reverse();
		
//		substring();
		
	}

	public static void substring() {
		/*
		 * 截取字符串, StringBuffer对象不会变化, 返回新的String
		 */
		
		StringBuffer sb = new StringBuffer("dfskdjfsfsf");
		String s1 = sb.substring(3);
		String s2 = sb.substring(3, 7);
		System.out.println(s1);
		System.out.println(s2);
	}

	public static void reverse() {
		/*
		 * 反转reverse
		 */
		StringBuffer sb = new StringBuffer("coppco");
		sb.reverse();
		System.out.println(sb);
	}

	public static void replace() {
		/*
		 * 替换replace
		 */
		StringBuffer sb = new StringBuffer("coppco");
		sb.replace(0, 3, "替换对对对");
		System.out.println(sb);
	}

	public static void delete() {
		/*
		 * delete 删除
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("coppco");
		sb.deleteCharAt(1);
		sb.delete(0, 2);
		System.out.println(sb);
	}

	public static void insert() {
		/*
		 * insert 插入
		 */
		StringBuffer sb = new StringBuffer();
		sb.insert(0, "coppco");
		System.out.println(sb);
	}

	public static void append() {
		/*
		 * append 拼接
		 */
		StringBuffer sb = new StringBuffer();
		sb.append(true);
		sb.append("coppco");
		
		System.out.println(sb);
	}

}
