class Demo_Test {
	public static void main(String[] args) {
		//��Outer���油�����, Ҫ�����Hello world!
		Outer.method().show();
	}
}

//�ӿ�
interface Inter {
	void show();
}

class Outer {
	public static Inter method() {
		//�����ڲ���(�ӿ�)
		return new Inter() {
			public void show() {
				System.out.println("Hello world!");
			}
		};
	}
}