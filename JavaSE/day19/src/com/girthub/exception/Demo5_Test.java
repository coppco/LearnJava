package com.girthub.exception;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class Demo5_Test {
	
	public static void main(String[] args) {
		String num = showTwo();
		System.out.println(num);
	}

	
	/*
	 * 输入整数, 转为二进制显示
	 */
	public static String showTwo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		
		while (true) {	
			String line = sc.nextLine();
			try {
				Integer num = Integer.parseInt(line);
				System.out.println("正确");
				return Integer.toBinaryString(num);
			} catch (Exception e) {
				try {
					new BigInteger(line);
					System.out.println("输入整数过大,请重新输入!");
				} catch (Exception e2) {
					try {
						new BigDecimal(line);
						System.out.println("输入的是小数, 请重新输入!");
					} catch (Exception e3) {
						System.out.println("输入是非法字符,请重新输入!");
					}
				}
			}
		}
		
		
	}
}
