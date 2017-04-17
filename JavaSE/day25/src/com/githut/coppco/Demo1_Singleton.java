package com.githut.coppco;

public class Demo1_Singleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

//����ʽ
class Singleton {
	//˽�л����췽��
	private Singleton() {	}
	private static Singleton s;
	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}
}
/*//����ʽ
class Singleton {
	//˽�л����췽��
	private Singleton() {	}
	
	private static Singleton s = new Singleton();
	
	public static Singleton getInstance() {
		return s;
	}
}*/
/*//ʹ��final
class Singleton {
	//˽�л����췽��
	private Singleton() {	}
	
	public static final Singleton shareInstance = new Singleton();

}*/