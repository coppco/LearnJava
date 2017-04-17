class Demo_Student {
	public static void main(String[] args) {
		
		Student student = new Student();
		student.name = "张三";
		System.out.println(student.age);

		student.study();
	}
}



/*
学生类
*/

class Student {
	//属性
	int age;
	String name;
	String gender;
	float wight;
	float height;

	public void study() {
		System.out.println(name + "学习了");
	}
}