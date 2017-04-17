package com.github.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3_FinallCode {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		newCopy("TheFatRat - Monody.mp3", "newCopy.mp3");
		copy("TheFatRat - Monody.mp3", "copy.mp3");
	} 
	
	//JDK1.6的写法
	public static void copy(String source, String dest) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(dest);
			byte[] arr = new byte[8*1024];
			int len;
			while ((len = in.read(arr)) != -1) {
				out.write(arr,0,len);
			}
			System.out.println("复制完成");
		} finally {
			try {
				if(in != null) {
					in.close();				
				}				
			} finally {
				if(out != null){
					out.close();				
				}				
			}
		}
	}
	
	//JDK1.7新写法
	public static void newCopy(String source, String dest) throws IOException {
		try (
				FileInputStream in = new FileInputStream(source);
				FileOutputStream out = new FileOutputStream(dest);
			){
				byte[] arr = new byte[8 * 1024];
				int len;
				while ((len = in.read(arr)) != -1) {
					out.write(arr,0,len);
				}
				System.out.println("新复制完成");
		}
	}
}
