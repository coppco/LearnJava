package com.github.string;

public class HJ_String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str);
		str = "def";
		System.out.println(str);
		
		
		byte[] arr = {97,86,54,5,7,0,127};
		String byteS = new String(arr);
		System.out.println(byteS);
		
		char[] arrC = {'a', 'b', 'L','9',' ','?'};
		String strC = new String(arrC);
		System.out.println(strC);
		arrC[0] = '1';
		System.out.println(strC);
		
	}

}
