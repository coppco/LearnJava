package com.coppco.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo_dom4j {

	public static void main(String[] args) throws DocumentException {		
	}
	
	@Test
	public void userDom4j() throws DocumentException {
		//获取核心对象
		 SAXReader saxReader = new SAXReader();
		 
		//获取dom
		Document dom = saxReader.read(new File("xml/test.xml"));
		 
		//获取根节点
		Element root = dom.getRootElement();
		
		
		//获取所有节点
		List elements = root.elements();
		/*
		for (Iterator it = elements.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		*/
		
		
		//获取节点下所有名为servlet的子节点
		List servlets = root.elements("servlet");
				
		//获取一个名为servlet的子节点
		Element servlet = root.element("servlet");
		
		//System.out.println(servlet.elements("servlet-name").size());
		/*
		Element servletName = servlet.addElement("servlet-name");
		Attribute attribute = servletName.attribute("id");
		
		String value = root.attributeValue("web-app");
		System.out.println(value);

		*/
		
		/*
		System.out.println(servlet);
		Attribute attribute = root.attribute("version");
		System.out.println(attribute.getText());
		System.out.println(attribute.getValue());
		
		System.out.println(root.attributeValue("version"));
		*/
		
//		System.out.println(root.element("servlet").element("servlet-name").attributeValue("id"));
		
		
		root.elements("servlet-name");
	}

}
