import java.util.Scanner;
class Demo_Method1 {
	public static void main(String[] args) {
		
		int aaa = count(8848);
		System.out.println("总次数是" + aaa);

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入行数:");
		int row = sc.nextInt();
		System.out.println("请输入列数:");
		int column = sc.nextInt();
		draw(row, column);
		
		while (true) {
			System.out.println("请输入乘法口诀数:(1~9)");
			int count = sc.nextInt();
			while (count > 9 | count < 1) {
				System.out.println("你输入的数有误,请重新输入");
				count = sc.nextInt();
			}
			print99(count);
		}
	}
	
	//打印*
	public static void draw(int row, int column) {
		for (int i = 1;i <= row ;i++ ) {
			for (int j = 1;j <= column ;j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//打印乘法口诀
	public static void print99(int a) {
		for (int i = 1;i <= a ;i++ ) {
			for (int j = 1;j <= i ;j++ ) {
				System.out.print(j  + "*" + i + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}

	public static int add(int a, int b) {
		return a + b;
	}
	public static double add(double a, int b) {
		return (a + b);
	}
	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	//计算次数
	public static int count(int total) {
		int i = 1;
		int count = 0;
		while (i <= total) {
			i *= 2;
			count++;
		}
		System.out.println(i);
		return count;
	}
}
