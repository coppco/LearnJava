class Demo_Conversion {
	public static void main(String[] args) {
		//��������ת�� 
		//��ʽת��
		int x = 12312123;
		byte b = 4;
		x = x + b; // ��ʽת��
		//ǿ��ת��
		b = (byte)(x + b);
		byte c = (byte)(126 + 4); //���-126
		System.out.println(x);
		System.out.println(b);
		System.out.println(c);

		byte b1 = 3;
		byte b2 = 4;
		//byte b3 = b1 + b2;
		byte b3 = (byte)(b1 + b2);
		System.out.println(b3);

		//
		float f = 12.4f;
		long y = 12345;

		f = y;
		y = (long)(f);
		System.out.println(f);
		System.out.println(x);

		System.out.println('a');  //a
		System.out.println('a' + 1); //98
		System.out.println((char)('a' + 1)); //b
	}
}
