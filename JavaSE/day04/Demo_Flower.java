/*
ˮ�ɻ���
һ����λ��: ���λ���������͵��ڸ�������  ��:153 = 1^3 + 5^3 + 3^3
*/
//import java.lang.math;
class Demo_Flower {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 100;i < 1000 ;i++ ) {
			if (i == ((i / 100) * (i / 100) * (i / 100) + (i / 10 % 10) * (i / 10 % 10) * (i / 10 % 10) + (i % 10) * (i % 10) * (i % 10))) {
				System.out.println("ˮ�ɻ���Ϊ" + i);
				count++;
			}
		}
		System.out.println("ˮ�ɻ�������" + count + "��");
	}
}
