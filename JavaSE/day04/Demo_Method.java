import java.util.Scanner;
class Demo_Method {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println(sum(1,2));




		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ������:");
		int a = sc.nextInt();
		System.out.println("������ڶ�������:");
		int b = sc.nextInt();
		
		System.out.println("���ֵ��" + max(a,b));
		System.out.println(isEqualTo(a,b));
	}
//	���
	public static int sum(int first, int second) {
		return first + second;
	}

	//�����
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	//�ж����
	public static boolean isEqualTo(int a, int b) {
		return a == b;
	}

	
}
