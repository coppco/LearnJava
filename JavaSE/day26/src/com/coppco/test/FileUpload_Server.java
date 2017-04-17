package com.coppco.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpload_Server {

	/**
	 * 3. �������߳�
	 * 4. ��ȡ�ļ���
	 * 5. �ж��ļ��Ƿ����, ����������ͻ���
	 * 6. �����ļ�
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(23232);
		
		while (true) {
			final Socket socket = server.accept();
			new Thread() {
				public void run() {
					try {
						InputStream inputStream = socket.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						
						File dir = new File("upload");
						dir.mkdir();
						File file = new File(dir,br.readLine());
						System.out.println(file);
						if (!file.exists()) {
							ps.println(true);
						} else {
							ps.println(false);
							socket.close();
						}
						
						//д���ļ�
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
						
						byte[] arr= new byte[8192];
						int length;	
						while ((length = inputStream.read(arr)) != -1) {
							bos.write(arr, 0, length);
						}
						System.out.println("��д���!!!!");
						
						bos.close();
						socket.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				};
			}.start();
			
		}
		
	}

}
