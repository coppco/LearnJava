package com.github.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1_FileReader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("xx.txt");
		FileWriter write = new FileWriter("copy.txt");
		int a;
		while ((a = reader.read()) != -1) {
			write.write(a);
		}
		reader.close();
		write.close();
	}

}
