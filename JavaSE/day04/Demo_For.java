class Demo_For {
	public static void main(String[] args) {

		//forѭ��
		for (int i = 1;i <= 10 ;i++ ) {
			System.out.println("��" + i + "�δ�ӡ����");
		}
		//1��10
		for (int i = 1;i <= 10 ;i++ ) {
			System.out.println(i);
		}

		//10��1
		for (int i = 10;i > 0 ;i-- ) {
			System.out.println(i);
		}
		//����1-100�ĺ� ż���� ������
		int sum = 0; //��
		int sum1 = 0; //ż����
		int sum2 = 0;  //������
		for (int i = 1;i <= 100 ;i++ ) {
			sum += i;
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}
		System.out.println("1-100�ĺ���" + sum);
		System.out.println("1-100��ż����" + sum1);
		System.out.println("1-100��������" + sum2);
	}
}
