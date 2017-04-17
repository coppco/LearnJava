package com.girthub.exception;

import java.io.File;
import java.io.IOException;

public class Demo6_File {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		
		
	}

	public static void create() throws IOException {
		File file1 = new File("xx.txt");
		file1.createNewFile();
		
		File file2 = new File("aaa");
		file2.mkdir();
		
		File file3 = new File("a//b//c");
		file3.mkdirs();
		
	}

	public static void demo1() {
		File file = new File("D:\\SourceTreeCode\\Backup-For-Blogspot\\source\\_posts");
		System.out.println(file.exists());
	}

}
