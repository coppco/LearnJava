package com.github.coppco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Vector;



public class Demo1_Sequ {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//two();
		//more
		FileInputStream fi1 = new FileInputStream("1.txt");
		FileInputStream fi2 = new FileInputStream("2.txt");
		FileInputStream fi3 = new FileInputStream("3.txt");
		Vector<FileInputStream> v = new Vector<>();
		v.add(fi1);
		v.add(fi2);
		v.add(fi3);

		SequenceInputStream s = new SequenceInputStream(v.elements());
		FileOutputStream o = new FileOutputStream("out.txt");
		int d;
		while ((d = s.read()) != -1) {
			o.write(d);
		}
		s.close();
		o.close();
	}

	public static void two() throws FileNotFoundException, IOException {
		FileInputStream fi1 = new FileInputStream("1.txt");
		FileInputStream fi2 = new FileInputStream("2.txt");

		SequenceInputStream sequence = new SequenceInputStream(fi1, fi2);

		FileOutputStream o = new FileOutputStream("3.txt");
		int d;
		while ((d = sequence.read()) != -1) {
			o.write(d);
		}
		sequence.close();
		o.close();
	}

}
