package com.github.set;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

import com.github.model.Student;

public class Demo8_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����¼��
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ����Ϣ, ��ʽ��(����,���ĳɼ�,��ѧ�ɼ�,Ӣ��ɼ�)");
		TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				float result = o1.getTotal() - o2.getTotal();
				return result == 0.0 ? 1 : (int)(result);
			};
		});
		
		while (ts.size() < 5) {
			System.out.println(ts.size());
			String st = sc.nextLine();
			st = st.replaceAll("[()]", "");
			String[] arr = st.split(",");
			Float chinese = Float.parseFloat(arr[1]);
			Float math = Float.parseFloat(arr[2]);
			Float english = Float.parseFloat(arr[3]);
			ts.add(new Student(arr[0], chinese, english, math));
		}
		
		for (Student student : ts) {
			System.out.println(student);
		}
	}

}
