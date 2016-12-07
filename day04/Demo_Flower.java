/*
水仙花数
一个三位数: 其各位数的立方和等于该数本身  如:153 = 1^3 + 5^3 + 3^3
*/
//import java.lang.math;
class Demo_Flower {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 100;i < 1000 ;i++ ) {
			if (i == ((i / 100) * (i / 100) * (i / 100) + (i / 10 % 10) * (i / 10 % 10) * (i / 10 % 10) + (i % 10) * (i % 10) * (i % 10))) {
				System.out.println("水仙花数为" + i);
				count++;
			}
		}
		System.out.println("水仙花数共有" + count + "个");
	}
}
