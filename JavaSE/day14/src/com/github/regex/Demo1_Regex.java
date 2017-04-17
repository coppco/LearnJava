package com.github.regex;

public class Demo1_Regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//校验QQ
		
		//System.out.println(checkQQ("112634"));
		String regex = "[1-9]\\d{4,14}";
		
		System.out.println("11212".matches(regex));
	}

	public static boolean checkQQ(String qq) {
		boolean flag = true;
		if (qq.length() >= 5 || qq.length() <= 15) {
			if (qq.startsWith("0")) {//以0开始
				flag = false;
			} else {
				char[] arr = qq.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char ch = arr[i];
					if (!(ch >= '0' && ch <= '9')) {//不说数字
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}
}
