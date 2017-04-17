package com.github.coppco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo4_RandomAccessFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		RandomAccessFile random = new RandomAccessFile("aa.txt", "rw");
		random.write(97);
		random.seek(10);
		random.write(98);
		random.close();
	}

}
