class Demo_For {
	public static void main(String[] args) {

		//for循环
		for (int i = 1;i <= 10 ;i++ ) {
			System.out.println("第" + i + "次打印操作");
		}
		//1到10
		for (int i = 1;i <= 10 ;i++ ) {
			System.out.println(i);
		}

		//10到1
		for (int i = 10;i > 0 ;i-- ) {
			System.out.println(i);
		}
		//计算1-100的和 偶数和 奇数和
		int sum = 0; //和
		int sum1 = 0; //偶数和
		int sum2 = 0;  //奇数和
		for (int i = 1;i <= 100 ;i++ ) {
			sum += i;
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}
		System.out.println("1-100的和是" + sum);
		System.out.println("1-100的偶数是" + sum1);
		System.out.println("1-100的奇数是" + sum2);
	}
}
