class Demo_Operator {
	public static void main(String[] args) {


		//++ 和 -- 的使用
		/*
		1. 单独使用
		a++ 和 ++a 效果是一样的

		2. 参与运算
		前后顺序位置不一样,结果也不一样, 在前面先自增或自减后参与运算,在后面先参与运算后自增或自减
		*/

		int a = 3;
		a++;  //a = a + 1  a=4
		++a;  //a = a + 1  a=5
	
		int b = a++;  //b = 5 a = 6
		int c = ++a;  // c = 7 a = 7

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		//第一题
		int x = 10, y = 10, z = 10;
		x = y++;  //x = 10, y = 11
		z = --x;  //x = 9, z = 9
		y = ++x;  //x = 10, y = 10
		x = z--;  //x = 9, z = 8
		System.out.println("x = " + x + " y = " + y + " z = " + z);

		//第二题
		int a1 = 4;
		int a2 = (a1++) + (++a1) + (a1 * 10); //4 + 6 + 60
		System.out.println("a2 = " + a2);
		

		//第三题:那句会报错  b1 = b1 + 1会报错,b1++系统底层会强制转换
		byte b1 = 7;
		b1++;
		//b1 = b1 + 1;  //需要b1 = (byte)(b1 + 1) type char short 混合运算的时候会提升到int类型, 赋值给type会损失精度
		System.out.println(b1);

		//第四题
		short s = 1;
		//s = s + 1;  //short type int 之间混合运算会提升到int类型, 再赋值给short 会损失精度
		short s1 = 1;
		s1 += 1;

		System.out.println(s);
		System.out.println(s1);

	}
}
