package com.github.string;

public class HJ_String_Mothed1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Demo0();
		
//		Demo1();
		
//		Demo3();
		
		String str = "dlsjfsdlldsldsljlJUEJLPOWIQJAKHHSNVBMCF7945613897846230789-++-[][]{}{}%^&*(";
		int upLetter = 0;
		int lowLetter = 0;
		int number = 0;
		int other = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z') {
				lowLetter++;
			} else if (c >= 'A' && c <= 'z') {
				upLetter++;
			} else if (c >= '0' && c <= '9') {
				number++;
			} else {
				other++;
			}
		}
		
		System.out.println("大写字符有:" + upLetter + "个, 小写字母有:" + lowLetter + "个, 数字有:" + number + "个, 其他字符有:" + other);
	}

	private static void Demo3() {
		String str = "123456789";
		for (int i = 0; i < str.length(); i++) {
			/*char c = str.charAt(i);
			System.out.println(c);*/
			System.out.println(str.charAt(i));
		}
		str = null;
		if (str == null) {
			System.out.println("空");
		}
	}

	private static void Demo0() {
		String s1 = "coppco";
		String s2 = "这里是中文哦!";
		String s3 = "";
		System.out.println(s1.length());
		System.out.println(s2.length());
		System.out.println(s3.length());
		
		String s4 = "coppco";
		char c = s4.charAt(0);
		System.out.println(c);
	}

	private static void Demo1() {
		String s5 = "abc";
		int index1 = s5.indexOf(97);
		int index3 = s5.indexOf(980);
		int index2 = s5.indexOf('b');
		
		System.out.println(index1 + index2);
		System.out.println(index3);
	}

}
