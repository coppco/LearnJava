class Demo_While {
	public static void main(String[] args) {
		
		//if for while 判断条件语句后面直接加个分号; 需要注意
		int x = 10;
		if (x == 0); {
			System.out.println("Hello World!");
		}

		/*
		打印
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
		打印
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
		打印乘法口诀
		*/

		for (int i = 1;i <= 9 ;i++ ) {
			for (int j = 1;j <= i ;j++ ) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}

		//标号: 合法的标识符即可
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
