package com.girthub.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo3_Throws {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	
	public static void readFile(String fileName) throws FileNotFoundException, IOException {
		FileInputStream fileIn = new FileInputStream(fileName);
		fileIn.close();
	}

}
