package com.github.login;

import java.util.Scanner;

public class HJ_Login {

	/**
	 * 模拟电路
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//次数
		int count = 3; 
		String name = "";
		String password = "";
		
		while (count > 0) {
			System.out.println("-------------");
			System.out.println("请输入用户名:");
			name = scanner.nextLine();
			System.out.println("请输入密码:");
			password = scanner.nextLine();
			
			if (!name.equals("admin") || !password.equals("admin")) {
				count--;
				if (count > 0) {
					System.out.println("用户名密码错误,你还有" + count + "次输入机会!");	
				} else {
					System.out.println("次数已经用完, 退出程序");
					break;
				}
				
			} else {
				System.out.println("用户名密码正确");
				break;
			}
			
		}
	}

}
