package com.github.udp;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo4_GUIChat extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button send;
	private Button log;
	private Button shake;
	private Button clear;
	private TextArea receiveT;
	private TextArea sendT;
	private TextField tf;
	private DatagramSocket socket;
	private BufferedWriter writer;

	private Demo4_GUIChat() {
		init();  //��ʼ��λ�� ��С
		southPanel(); //�·������
		centerPanel();  //��ʾ�ı�
		event(); //�¼�
		
		receiveMessage(); //���ܷ���
	}
	private void receiveMessage() {
		new ReceiveThread().start();
	}
	private void event() {
		//�رհ�ť
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//�رհ�ť
				socket.close();
				try {
					writer.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		//���Ͱ�ť�¼�
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					send();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		//����
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				receiveT.setText("");
			}
		});
		//��¼
		log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					logFile();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		//��
		shake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				shake();
				String ip = tf.getText(); //��ȡip��ַ

				try {
					DatagramPacket packet = new DatagramPacket(new byte[] {-1}, 1, InetAddress.getByName(ip), 9999);
					socket.send(packet);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		//���̼���
		sendT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) { //��סctrl Ȼ�󰴻س�
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { //���س�	
					try {
						send();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
	}
	protected void shake() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		
		for (int i = 0; i < 5; i++) {
			try {
				this.setLocation(x + 20, y + 20);
				Thread.sleep(20);
				this.setLocation(x + 20, y - 20);
				Thread.sleep(20);
				this.setLocation(x - 20, y + 20);
				Thread.sleep(20);
				this.setLocation(x - 20, y - 20);
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setLocation(x, y);
	}
	protected void logFile() throws IOException {
		writer.flush(); //ˢ�»���
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("config.txt"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); //���ڴ��д���������
		int length;
		while ((length = bis.read()) != -1) {
			baos.write(length);
		}
		
		String str = baos.toString();
		receiveT.setText(str);
		bis.close();
		baos.close();
	}
	//������Ϣ
	protected void send() throws IOException {
		String message = sendT.getText(); //��ȡ������������
		String ip = tf.getText(); //��ȡip��ַ
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
		DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName(ip), 9999);
		socket.send(packet);
		
		String time = getCurrentTime();
		String writeMessage = time + "  �Ҷ�" + ("255.255.255.255".equals(ip) ? "������" : ip) + "˵\r\n" + message;
		writer.write(writeMessage); //д���ı���
		
		receiveT.append(writeMessage);
		sendT.setText("");
	}
	//ʱ���ʽ��
	private String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
	//�м䲿��
	private void centerPanel() {
		Panel center = new Panel();
		receiveT = new TextArea();
		receiveT.setEditable(false); //���������ܱ༭
		receiveT.setBackground(Color.WHITE);//���ñ�����ɫ
		sendT = new TextArea(5, 1);
		
		//��������
		receiveT.setFont(new Font("xxx", Font.PLAIN, 15));
		sendT.setFont(new Font("xxx", Font.PLAIN, 15));
		
		center.setLayout(new BorderLayout()); //����Ϊ �߽粼�ֹ�����
		center.add(sendT, BorderLayout.SOUTH); //�����ϱ�
		center.add(receiveT, BorderLayout.CENTER);//�����м�
		
		this.add(center, BorderLayout.CENTER);
	}
	//���沿��
	private void southPanel() {
		Panel south = new Panel();
		tf = new TextField("127.0.0.1", 10);
		send = new Button("����");
		log = new Button("��¼");
		clear = new Button("����");
		shake = new Button("��");
		
		south.add(tf);
		south.add(send);
		south.add(log);
		south.add(clear);
		south.add(shake);
		
		this.add(south, BorderLayout.SOUTH);//��south����frame���ϱ�
	}

	private void init() {
		this.setLocation(450, 50);
		this.setSize(400, 600);
		
		try {
			writer = new BufferedWriter(new FileWriter("config.txt", true));
			socket = new DatagramSocket();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	
	
	private class ReceiveThread extends Thread {
		@Override
		public void run() {
			DatagramSocket socket;
			try {
				socket = new DatagramSocket(9999);
				while (true) {
					DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
					socket.receive(packet);
					if (packet.getData()[0] == -1 && packet.getLength()== 1) {
						shake();	
					} else {
						String message = new String(packet.getData(), 0, packet.getLength());
						String writeMessage = "\r\n" + getCurrentTime() + "  " + packet.getAddress().getHostAddress() + "����˵\r\n" + message + "\r\n\r\n";
						writer.write(writeMessage);
						receiveT.append(writeMessage);
					}				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Demo4_GUIChat();
	}

}