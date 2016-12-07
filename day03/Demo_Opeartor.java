class Demo_Opeartor {
	public static void main(String[] args) {
		
		
		/*
		1. & 按位与  有0则0
		2. | 按位或  有1则1
		3. ^ 按位异或 相同为0, 不同为1
		4. ~ 按位取反 按位取反
		*/

		int a = 10, b = 5;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		/*
		a = a + b;
		b = a - b;
		a = a - b;
		*/
		/*
		a = a * b;
		b = a / b;
		a = a / b;
		*/
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		System.out.println(13 << 1);
		System.out.println(13 >> 1);
		//计算2 * 8的结果
		System.out.println(2 << 3);

		//三目运算符
		// 关系表达式 ? 表达式1 : 表达式2

		boolean bb = true;
		int cc = bb == false ? 1 : 2;
		System.out.println(cc);

	}
}
