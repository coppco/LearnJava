class Demo_DataType {
	public static void main(String[] args) {
		//整数类型
		byte b = 10;  //byte占一个字节, -128~127
		b = 127; //1l
		short s = 20;  //short 占两个字节
		int i = 30;    //int 占四个字节, 整数默认都是int类型
		long x = 8888888888L;  //long 占8个字节, 最好加L  小写也可以但是和1(一)太相似了
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(x);

		//浮点型
		float f = 12.3f; // 占四个字节
		double d = 33.5; //占8个字节  浮点数默认是double类型
		System.out.println(f);
		System.out.println(d);

		//字符类型
		char c = 'a';  //两个字节
		System.out.println(c);

		//布尔类型
		boolean b1 = false;
		boolean b2 = true;
		System.out.println(b1);
		System.out.println(b2);
	}
}
