package com.coppco.demo2;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo_ReadXML {
	
	
	
	public static void readXML() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document dom = saxReader.read("xml/readXML.xml");
		
		String servlet_name = dom.selectSingleNode("//servlet/servlet-name").getText();
		String servlet_class = dom.selectSingleNode("//servlet/servlet-class").getText();
		
		System.out.println(servlet_class + ":" + servlet_name);
	}
	
	
	@Test
	public void test1() throws DocumentException {
		Demo_ReadXML.readXML();
	}
}
