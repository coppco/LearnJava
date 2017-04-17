package com.coppco.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendMessage_TCP_Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12222);
		while (true) {
			final Socket socket = server.accept();
			new Thread() {
				public void run() {
					while (true) {
						try {
							BufferedReader br = new BufferedReader(new InputStreamReader(
									socket.getInputStream()));
							PrintStream ps = new PrintStream(socket.getOutputStream());
							String message = br.readLine();
							System.out.println("������յ���Ϣ: " + message);
							String sendMessage = new StringBuffer(message).reverse().toString();
							ps.println(sendMessage);
							System.out.println("����˷�����Ϣ: " + sendMessage);
						} catch (Exception e) {
							e.printStackTrace();	
							break;
						} 
					}
				};
			}.start();
		}
	}

}
