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
	 * 1. 提示输入文件路径，　并判断
	 * 2. 发送文件名称到服务器
	 * 6. 接受结果, 如果存在给予提示, 程序退出
	 * 7. 如果不存在, 上传文件
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		File file = getFile();
		Socket socket = new Socket("127.0.0.1", 23232);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		System.out.println("上传文件名称到服务器: " + file.getName());
		ps.println(file.getName());
		
		//判断是否存在
		if ("false".equals(br.readLine())) {
			System.out.println("你上传的文件已经存在!");
			socket.close();
			System.exit(0);
		}
		
		//发送数据
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		int length;
		while ((length = bis.read()) != -1) {
			ps.write(length); //传到服务器
		}
		
		bis.close();
		socket.close();
			
	}
	
	public static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件路径: ");
		
		while (true) {
			String name = sc.nextLine();
			File file = new File(name);
			if (!file.exists()) {
				System.out.println("你输入的文件路径不存在, 请重新输入!");
			} else if (file.isDirectory()) {
				System.out.println("你输入的是文件夹路径, 请重新输入!");				
			} else {
				return file;
			}
		}
	}
}
