package com.github.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo5_Client {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		//获取客户端输入流
		InputStream input = socket.getInputStream();
		//获取客户端的输出流
		OutputStream output = socket.getOutputStream();
		
		byte[] arr = new byte[1024];
		int length = input.read(arr);
		
		System.out.println(new String(arr, 0, length));
		
		output.write("学无止境!!".getBytes());
		
		socket.close();
	}

}
