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
		//泛型只在编译的时候有效, 运行期泛型会被擦除
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		//list.add(123); //字符串集合中直接添加int数出错, 可以使用反射来添加
		Method m = list.getClass().getMethod("add", Object.class);
		m.invoke(list, 123);
		
		System.out.println(list);
	}

}
