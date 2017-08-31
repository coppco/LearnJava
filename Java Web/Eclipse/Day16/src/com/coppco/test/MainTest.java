package com.coppco.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {

//	public static void main(String[] args) {
//		//CLass对象
//		Class clazz = TestClass.class;
//
//		//获取所有方法
//		
//		Method[] arr = clazz.getMethods();
//		
//		for (Method method : arr) {
//			System.out.println(method.getName());
//		}
//	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		@SuppressWarnings("rawtypes")
		Class clazz = TestClass.class;
		
		//获取所有方法
		Method[] arr = clazz.getMethods();
		
		//让带注解的方法执行
		for (Method method : arr) {
			if (method.isAnnotationPresent(MyTODO.class)) {
				System.out.println(method.getName());
				method.invoke(clazz.newInstance());
			}
		}
	}

}
