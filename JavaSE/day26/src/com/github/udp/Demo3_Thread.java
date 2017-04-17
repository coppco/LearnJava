package com.github.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Demo3_Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread receive = new Thread() {
			public void run() {
				try {
					DatagramSocket socket = new DatagramSocket(8010);
					DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
					while (true) {						
						socket.receive(packet);
						System.out.println(new String(packet.getData(), 0, packet.getLength()));
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			};
		};
		Thread send = new Thread() {
			public void run() {
				try {
					DatagramSocket socket = new DatagramSocket();
					Scanner sc = new Scanner(System.in);
					while (true) {
						String data = sc.nextLine();
						if ("quit".equals(data)) {
							break;
						}
						DatagramPacket packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getByName("127.0.0.1"), 8010);
						socket.send(packet);
					}
					socket.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			};
		};
		
		receive.start();
		send.start();
	}

}
