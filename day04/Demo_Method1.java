import java.util.Scanner;
class Demo_Method1 {
	public static void main(String[] args) {
		
		int aaa = count(8848);
		System.out.println("�ܴ�����" + aaa);

		Scanner sc = new Scanner(System.in);
		System.out.println("����������:");
		int row = sc.nextInt();
		System.out.println("����������:");
		int column = sc.nextInt();
		draw(row, column);
		
		while (true) {
			System.out.println("������˷��ھ���:(1~9)");
			int count = sc.nextInt();
			while (count > 9 | count < 1) {
				System.out.println("�������������,����������");
				count = sc.nextInt();
			}
			print99(count);
		}
	}
	
	//��ӡ*
	public static void draw(int row, int column) {
		for (int i = 1;i <= row ;i++ ) {
			for (int j = 1;j <= column ;j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//��ӡ�˷��ھ�
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

	//�������
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
