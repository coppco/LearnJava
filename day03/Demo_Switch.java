import java.util.Scanner;
class Demo_Switch {
	public static void main(String[] args) {
		String name = "����";
		String gender = "��ʿ";
		switch (gender) {
		case "��ʿ":
			System.out.println("����Ϸ");
		break;
		case "Ůʿ":
			System.out.println("��֡�����");
		break;
		default:
			System.out.println("����");
		break;
		}


		Scanner sc = new Scanner(System.in);
		System.out.println("�������·�:");
		int month = sc.nextInt();
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("����");
		break;
		case 6:
		case 7:
		case 8:
			System.out.println("�ļ�");
		break;
		case 9:
		case 10:
		case 11:
			System.out.println("�＾");
		break;
		case 12:
		case 1:
		case 2:
			System.out.println("����");
		break;
		default:
			System.out.println("������·�");
			break;
		}
	}
}
