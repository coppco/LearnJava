package com.coppco.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Demo_案例1 {

	@Test
	public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Map<String, String> map = new HashMap<>();
		map.put("hello", "com.coppco.demo1.Demo_案例1");
		
		String className = map.get("hello");
		
		Class clazz = Class.forName(className);
		
		Object newInstance = clazz.newInstance();
		
		Method method = clazz.getMethod("add");
		
		method.invoke(newInstance);
	}
	
	public void add() {
		System.out.println("添加函数");
	}
	
}
