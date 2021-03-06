package com.githut.coppco;

public class Demo1_Singleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

//懒汉式
class Singleton {
	//私有化构造方法
	private Singleton() {	}
	private static Singleton s;
	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}
}
/*//饿汉式
class Singleton {
	//私有化构造方法
	private Singleton() {	}
	
	private static Singleton s = new Singleton();
	
	public static Singleton getInstance() {
		return s;
	}
}*/
/*//使用final
class Singleton {
	//私有化构造方法
	private Singleton() {	}
	
	public static final Singleton shareInstance = new Singleton();

}*/