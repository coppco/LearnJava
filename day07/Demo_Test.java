class Demo_Test {
	public static void main(String[] args) {
		//在Outer里面补齐代码, 要求输出Hello world!
		Outer.method().show();
	}
}

//接口
interface Inter {
	void show();
}

class Outer {
	public static Inter method() {
		//匿名内部类(接口)
		return new Inter() {
			public void show() {
				System.out.println("Hello world!");
			}
		};
	}
}