package com.github.coppco;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo3_TReflect {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//����ֻ�ڱ����ʱ����Ч, �����ڷ��ͻᱻ����
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		//list.add(123); //�ַ���������ֱ������int������, ����ʹ�÷���������
		Method m = list.getClass().getMethod("add", Object.class);
		m.invoke(list, 123);
		
		System.out.println(list);
	}

}