class Demo_Student {
	public static void main(String[] args) {
		
		Student student = new Student();
		student.name = "����";
		System.out.println(student.age);

		student.study();
	}
}



/*
ѧ����
*/

class Student {
	//����
	int age;
	String name;
	String gender;
	float wight;
	float height;

	public void study() {
		System.out.println(name + "ѧϰ��");
	}
}