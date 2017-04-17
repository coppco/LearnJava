package com.github.coppco;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2_NeiCun {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//du();
		
		//ByteArrayOutputStream
		FileInputStream in = new FileInputStream("zhongwen.txt");;
		
		byte[] arr = new byte[5];
		int d;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		while ((d = in.read(arr)) != -1) {
			out.write(arr, 0, d);
		}
		System.out.println(out.toString());
		in.close();

	}

	public static void du() throws FileNotFoundException, IOException {
		FileInputStream in = new FileInputStream("zhongwen.txt");;
		byte[] arr = new byte[2];
		int d;
		while ((d = in.read(arr)) != -1) {
			System.out.println(new String(arr, 0, d));
		}
	}

}
