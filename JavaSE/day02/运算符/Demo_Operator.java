class Demo_Operator {
	public static void main(String[] args) {


		//++ �� -- ��ʹ��
		/*
		1. ����ʹ��
		a++ �� ++a Ч����һ����

		2. ��������
		ǰ��˳��λ�ò�һ��,���Ҳ��һ��, ��ǰ�����������Լ����������,�ں����Ȳ���������������Լ�
		*/

		int a = 3;
		a++;  //a = a + 1  a=4
		++a;  //a = a + 1  a=5
	
		int b = a++;  //b = 5 a = 6
		int c = ++a;  // c = 7 a = 7

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		//��һ��
		int x = 10, y = 10, z = 10;
		x = y++;  //x = 10, y = 11
		z = --x;  //x = 9, z = 9
		y = ++x;  //x = 10, y = 10
		x = z--;  //x = 9, z = 8
		System.out.println("x = " + x + " y = " + y + " z = " + z);

		//�ڶ���
		int a1 = 4;
		int a2 = (a1++) + (++a1) + (a1 * 10); //4 + 6 + 60
		System.out.println("a2 = " + a2);
		

		//������:�Ǿ�ᱨ��  b1 = b1 + 1�ᱨ��,b1++ϵͳ�ײ��ǿ��ת��
		byte b1 = 7;
		b1++;
		//b1 = b1 + 1;  //��Ҫb1 = (byte)(b1 + 1) type char short ��������ʱ���������int����, ��ֵ��type����ʧ����
		System.out.println(b1);

		//������
		short s = 1;
		//s = s + 1;  //short type int ֮���������������int����, �ٸ�ֵ��short ����ʧ����
		short s1 = 1;
		s1 += 1;

		System.out.println(s);
		System.out.println(s1);

	}
}
