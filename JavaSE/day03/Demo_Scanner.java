import java.util.Scanner;  //������е���
class Demo_Scanner {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in); //��������¼�����
		System.out.println("������һ������:");
		int x = sc.nextInt(); //������¼��洢��x��
		System.out.println(x);
		*/

		/*
		//��ϰ1: ������������������
		Scanner sc = new Scanner(System.in); //����¼�����
		System.out.println("�������һ������:");
		int x = sc.nextInt();
		System.out.println("������ڶ�������:");
		int y = sc.nextInt();
		System.out.println("�������ĺ���" + (x + y));
		*/

		//��ϰ2: ��ȡ����¼�������������ֵ
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ������:");
		int x = sc.nextInt();
		System.out.println("������ڶ�������:");
		int y = sc.nextInt();
		System.out.println("�������е����ֵ��:" + (x > y ? x : y));
		System.out.println("���������������:");
		int z = sc.nextInt();
		System.out.println("�������е����ֵ��:" + ((x > y ? x : y) > z ? (x > y ? x : y) : z));
	}
}
