package com.github.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo5_Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(12345);
		Socket socket = server.accept();
		
		//��ȡ�ͻ���������
		InputStream input = socket.getInputStream();
		//��ȡ�ͻ��˵������
		OutputStream output = socket.getOutputStream();
		
		output.write("�ٶ�һ�� ���֪��".getBytes());
		
		byte[] arr = new byte[1024];
		int length = input.read(arr);
		
		System.out.println(new String(arr, 0, length));
		
		
	}

}