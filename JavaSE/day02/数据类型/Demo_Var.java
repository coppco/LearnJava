class Demo_Var {
	public static void main(String[] args) {
		int x = 10;
		//int x = 20;  //同一个作用域不能重复定义相同的变量
		System.out.println(x);
		int y;    
		//y = 2000;
		//System.out.println(y);  //使用之前需要赋值

		float a = 10, b = 30, c = 30;  //一条语句可以声明多个相同类型变量
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
