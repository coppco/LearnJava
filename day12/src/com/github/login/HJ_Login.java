package com.github.login;

import java.util.Scanner;

public class HJ_Login {

	/**
	 * ģ���·
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//����
		int count = 3; 
		String name = "";
		String password = "";
		
		while (count > 0) {
			System.out.println("-------------");
			System.out.println("�������û���:");
			name = scanner.nextLine();
			System.out.println("����������:");
			password = scanner.nextLine();
			
			if (!name.equals("admin") || !password.equals("admin")) {
				count--;
				if (count > 0) {
					System.out.println("�û����������,�㻹��" + count + "���������!");	
				} else {
					System.out.println("�����Ѿ�����, �˳�����");
					break;
				}
				
			} else {
				System.out.println("�û���������ȷ");
				break;
			}
			
		}
	}

}
