class Demo_While {
	public static void main(String[] args) {
		
		//if for while �ж�����������ֱ�ӼӸ��ֺ�; ��Ҫע��
		int x = 10;
		if (x == 0); {
			System.out.println("Hello World!");
		}

		/*
		��ӡ
		****
		****
		****
		****
		*/

		for (int i = 0;i <= 3 ;i++ ) {
			for (int j = 0;j <= 3 ;j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		��ӡ
		*
		**
		***
		****
		*/

		for (int i = 0;i <= 3 ;i++ ) {
			for (int j = 0;j <= i ;j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}

		/*
		��ӡ�˷��ھ�
		*/

		for (int i = 1;i <= 9 ;i++ ) {
			for (int j = 1;j <= i ;j++ ) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}

		//���: �Ϸ��ı�ʶ������
		a: for (int i = 1;i <= 10 ;i++ ) {
			b: for (int j = 1;j <= 10 ;j++ ) {
				if (i * j == 8) {
					System.out.print("i = " + i + "\tj = " + j + '\n');
					break a;
				}
			}
		}
	}
}
