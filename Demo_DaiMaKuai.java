class Demo_DaiMaKuai {
	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student(12, "张三");
		System.out.println("Hello World!");

	}

	static {
			System.out.println("静态代码块main");
		}
}

 class Student {
		//私有化成员变量
		private int age;
		private String name;
		
		//默认构造方法
		public Student() {
		}

		//重载构造方法
		public Student(int age, String name) {
			this.age = age;
			this.name = name;
		}

		//set和get
		public void setAge(int age) {
			this.age = age;
		}
		public int getAge() {
			return this.age;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		//构造代码块, 每次调用构造方法都会执行,并且在构造方法之前执行
		{
			System.out.println("构造代码块");
		}

		static {
			System.out.println("静态代码块Student");
		}
	}