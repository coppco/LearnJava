package com.github.coppco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.github.bean.Person;

public class Demo3_ObjectStream {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Person p = new Person("ÕÅÈý", 24);
		//Ð´
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Person.txt"));
		out.writeObject(p);
		out.close();
		//¶Á
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Person.txt"));
		Object o = in.readObject();
		if (o instanceof Person) {
			Person newP = (Person)o;
			System.out.println(newP.getName());
		}
		
	}

}
