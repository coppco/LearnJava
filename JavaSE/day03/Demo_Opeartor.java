class Demo_Opeartor {
	public static void main(String[] args) {
		
		
		/*
		1. & ��λ��  ��0��0
		2. | ��λ��  ��1��1
		3. ^ ��λ��� ��ͬΪ0, ��ͬΪ1
		4. ~ ��λȡ�� ��λȡ��
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
		//����2 * 8�Ľ��
		System.out.println(2 << 3);

		//��Ŀ�����
		// ��ϵ���ʽ ? ���ʽ1 : ���ʽ2

		boolean bb = true;
		int cc = bb == false ? 1 : 2;
		System.out.println(cc);

	}
}
