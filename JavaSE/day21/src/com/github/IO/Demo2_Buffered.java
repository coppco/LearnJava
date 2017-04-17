package com.github.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Demo2_Buffered {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//read_write();
		
		//LineNumberReader
		
		
		//zhidingmabiao();
		
		FileInputStream read = new FileInputStream("utf-8.txt");
		FileOutputStream write = new FileOutputStream("gbk.txt");
		int d;
		while ((d = read.read()) != -1) {
			write.write(d);
		}
		read.close();
		write.close();
	}

	public static void zhidingmabiao() throws UnsupportedEncodingException,
			FileNotFoundException, IOException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8");
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
		
		int d;
		while ((d = reader.read()) != -1) {
			writer.write(d);
		}
		
		reader.close();
		writer.close();
	}

	public static void read_write() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("xx.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"));
		
		String st;
		while ((st = reader.readLine()) != null) {
			writer.write(st);
			writer.newLine();
		}
		
		reader.close();
		writer.close();
	}

}
