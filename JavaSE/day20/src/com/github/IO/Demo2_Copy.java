package com.github.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.attribute.standard.MediaSize.Other;

public class Demo2_Copy {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream input = new FileInputStream("TheFatRat - Monody.mp3");
		FileOutputStream output = new FileOutputStream("copy.mp3");
		/*
		//一个字节一个字节的读写
		int d;
		while ((d = input.read()) != -1) {
			output.write(d);
		}*/
		/*
		//整体拷贝
		byte[] read = new byte[input.available()];
		input.read(read);
		output.write(read);
		*/
		//小数组拷贝 1024*8 推荐
		/*byte[] arr = new byte[1024*8];
		int len;
		
		while ((len = input.read(arr)) != -1) {
			output.write(arr, 0, len);
		}*/
		BufferedInputStream bis = new BufferedInputStream(input);
		BufferedOutputStream bos = new BufferedOutputStream(output);
		int b;
		while ((b = bis.read()) != -1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
		input.close();
		output.close();
		System.out.println("拷贝完成了");
	}

}
