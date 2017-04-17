import java.util.Scanner;
class Demo_Method {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println(sum(1,2));




		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个整数:");
		int a = sc.nextInt();
		System.out.println("请输入第二个整数:");
		int b = sc.nextInt();
		
		System.out.println("最大值是" + max(a,b));
		System.out.println(isEqualTo(a,b));
	}
//	求和
	public static int sum(int first, int second) {
		return first + second;
	}

	//最大数
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	//判断相等
	public static boolean isEqualTo(int a, int b) {
		return a == b;
	}

	
}
