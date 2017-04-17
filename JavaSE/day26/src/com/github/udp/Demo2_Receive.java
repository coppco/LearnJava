package com.github.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo2_Receive {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(6666);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		while (true) {
			socket.receive(packet);			
			System.out.println(packet.getAddress().getHostAddress() + new String(packet.getData(), 0,packet.getLength()));
		}
//		socket.close();
		
	}

}
