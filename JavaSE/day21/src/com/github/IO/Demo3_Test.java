package com.github.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Demo3_Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
		TreeMap<Character, Integer> tm = new TreeMap<>();
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("time.txt"), "utf-8"));
		write.write("Ô­×Ö·û: ");
		int ch;
		while ((ch = reader.read()) != -1) {
			char c = (char)ch;
			write.write(ch);
			tm.put((char)ch, tm.containsKey(c) ? tm.get(c) + 1 : 1);
		}
		reader.close();
		write.newLine();
		write.flush();
		
		for (Entry<Character, Integer> entry : tm.entrySet()) {
			write.write(entry.getKey() + ": " + entry.getValue() + "¸ö");
			write.newLine();
		}
		
		write.close();
		
	}

}
