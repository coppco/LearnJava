import java.util.Scanner;  //导入包中的类
class Demo_Scanner {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in); //创建键盘录入对象
		System.out.println("请输入一个整数:");
		int x = sc.nextInt(); //将键盘录入存储到x中
		System.out.println(x);
		*/

		/*
		//练习1: 计算两个数并计算结果
		Scanner sc = new Scanner(System.in); //创建录入对象
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();
		System.out.println("两个数的和是" + (x + y));
		*/

		//练习2: 获取键盘录入两个数的最大值
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个整数:");
		int x = sc.nextInt();
		System.out.println("请输入第二个整数:");
		int y = sc.nextInt();
		System.out.println("两个数中的最大值是:" + (x > y ? x : y));
		System.out.println("请输入第三个整数:");
		int z = sc.nextInt();
		System.out.println("三个数中的最大值是:" + ((x > y ? x : y) > z ? (x > y ? x : y) : z));
	}
}
