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
	 * ��������, תΪ��������ʾ
	 */
	public static String showTwo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������:");
		
		while (true) {	
			String line = sc.nextLine();
			try {
				Integer num = Integer.parseInt(line);
				System.out.println("��ȷ");
				return Integer.toBinaryString(num);
			} catch (Exception e) {
				try {
					new BigInteger(line);
					System.out.println("������������,����������!");
				} catch (Exception e2) {
					try {
						new BigDecimal(line);
						System.out.println("�������С��, ����������!");
					} catch (Exception e3) {
						System.out.println("�����ǷǷ��ַ�,����������!");
					}
				}
			}
		}
		
		
	}
}
