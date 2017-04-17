import java.util.Scanner;
class Demo_Switch {
	public static void main(String[] args) {
		String name = "张三";
		String gender = "男士";
		switch (gender) {
		case "男士":
			System.out.println("打游戏");
		break;
		case "女士":
			System.out.println("逛街、美容");
		break;
		default:
			System.out.println("人妖");
		break;
		}


		Scanner sc = new Scanner(System.in);
		System.out.println("请输入月份:");
		int month = sc.nextInt();
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("春季");
		break;
		case 6:
		case 7:
		case 8:
			System.out.println("夏季");
		break;
		case 9:
		case 10:
		case 11:
			System.out.println("秋季");
		break;
		case 12:
		case 1:
		case 2:
			System.out.println("冬季");
		break;
		default:
			System.out.println("错误的月份");
			break;
		}
	}
}
