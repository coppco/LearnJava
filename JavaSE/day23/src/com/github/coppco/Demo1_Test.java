package com.github.coppco;

import java.io.File;
import java.util.Scanner;

public class Demo1_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = inputName();
		long length = getFileLength(file);
		System.out.println(length);
	}
	
	//����¼���ļ�·��
	public static File inputName() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("�������ļ�������:");
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("�Ҳ�����Ӧ���ļ��л����ļ�!!");
				
			} else {
				return file;
			}
		}
	}
	
	
	//��ȡ�ļ��д�С
	public static long getFileLength(File dir) {
		long total = 0;
		if (dir.isFile()) {
			return dir.length();
		} else {
			File[] files = dir.listFiles();
			for (File subFile : files) {
				if (subFile.isFile()) {
					total = total + subFile.length();
				} else if (subFile.isDirectory() && !subFile.isHidden()) {
					total = total + getFileLength(subFile);
				}
			}
		}
		return total;
	}
}
