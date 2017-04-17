package com.coppco.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendMessage_TCP_Client {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 12222);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			String message = sc.nextLine();
			System.out.println("客户端发送消息: " + message);
			ps.println(message);
			System.out.println("客户端收到信息: " + br.readLine());
		}
	}


}
