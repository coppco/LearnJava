class Demo_DaiMaKuai {
	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student(12, "����");
		System.out.println("Hello World!");

	}

	static {
			System.out.println("��̬�����main");
		}
}

 class Student {
		//˽�л���Ա����
		private int age;
		private String name;
		
		//Ĭ�Ϲ��췽��
		public Student() {
		}

		//���ع��췽��
		public Student(int age, String name) {
			this.age = age;
			this.name = name;
		}

		//set��get
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
		
		//��������, ÿ�ε��ù��췽������ִ��,�����ڹ��췽��֮ǰִ��
		{
			System.out.println("��������");
		}

		static {
			System.out.println("��̬�����Student");
		}
	}