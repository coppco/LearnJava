package com.coppco.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileUpload_Client {

	/**
	 * 1. ��ʾ�����ļ�·���������ж�
	 * 2. �����ļ����Ƶ�������
	 * 6. ���ܽ��, ������ڸ�����ʾ, �����˳�
	 * 7. ���������, �ϴ��ļ�
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		File file = getFile();
		Socket socket = new Socket("127.0.0.1", 23232);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		System.out.println("�ϴ��ļ����Ƶ�������: " + file.getName());
		ps.println(file.getName());
		
		//�ж��Ƿ����
		if ("false".equals(br.readLine())) {
			System.out.println("���ϴ����ļ��Ѿ�����!");
			socket.close();
			System.exit(0);
		}
		
		//��������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		int length;
		while ((length = bis.read()) != -1) {
			ps.write(length); //����������
		}
		
		bis.close();
		socket.close();
			
	}
	
	public static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ļ�·��: ");
		
		while (true) {
			String name = sc.nextLine();
			File file = new File(name);
			if (!file.exists()) {
				System.out.println("��������ļ�·��������, ����������!");
			} else if (file.isDirectory()) {
				System.out.println("����������ļ���·��, ����������!");				
			} else {
				return file;
			}
		}
	}
}