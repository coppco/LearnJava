package com.github.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo5_File {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("E:\\");
		findFile(file);
	}

	public static void findFile(File file) throws IOException {
		for (File subFile : file.listFiles()) {
			System.out.println(subFile);
			if (subFile.isFile()) {
				System.out.println(subFile);
				BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileList.txt", true), "utf-8"));
				write.write(subFile.getAbsolutePath());
				write.newLine();
				write.close();
			} else if (subFile.isDirectory() && !subFile.isHidden()) {
				findFile(subFile);
			}
		}
	}

	
}
