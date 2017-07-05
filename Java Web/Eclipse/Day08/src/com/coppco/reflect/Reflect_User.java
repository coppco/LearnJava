package com.coppco.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Reflect_User {
	public void add() {
		System.out.println("这是空参函数");
	}
	
	public void add(int i, int j) {
		System.out.println("带两个参数i+j=" + (i + j));
	}
	
	public int add(int i) {
		System.out.println("add, 只有一个参数, 有返回值!");
		return i;
	}
	
	
	@Test
	public void test1() {
		//方式1: 直接创建
		new Reflect_User().add();
	}
	@Test
	public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//方式2: 通过反射获取对象
		Class className = Class.forName("com.coppco.reflect.Reflect_User");
		
		
		Reflect_User newInstance = (Reflect_User)className.newInstance();
		
		newInstance.add();
	}
	
	@Test
	public void test3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//方式2: 通过反射获取方法
		Class className = Class.forName("com.coppco.reflect.Reflect_User");
		
		Method method = className.getMethod("add");
		
		Reflect_User newInstance = (Reflect_User)className.newInstance();
		
		method.invoke(newInstance);
		
		
	}
}
