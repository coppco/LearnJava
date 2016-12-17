class Demo_InnerClass {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Outer.Inner oi = new Outer().new Inner();
		oi.method();
	}
}



class Outer {
	class Inner {
		public void method() {
			System.out.println("method");
		}
	}
}