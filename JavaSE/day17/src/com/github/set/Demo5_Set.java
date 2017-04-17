package com.github.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Demo5_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> ls = new ArrayList<>();
		ls.add("abc");
		ls.add("edsaf");
		ls.add("dfs");
		ls.add("abc");
		ls.add("dfda");
		ls.add("dsfaf");
		ls.add("sere");
		ls.add("dsaf");
		
		//���򲢱����ظ�
		sorted(ls);  //ctrl + 1 ���ɷ���
		
		System.out.println(ls);
	}

	public static void sorted(List<String> ls) {
		//ʹ�������ڲ�����ʵ��
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.compareTo(o2) == 0) {
					return -1;
				}
				return o1.compareTo(o2);
			}
			@Override
			public boolean equals(Object obj) {
				
				return super.equals(obj);
			}
		});
		
		
		for (String string : ls) {
			ts.add(string);
		}
		ls.clear();
		for (String string : ts) {
			ls.add(string);
		}
		ts.clear();
		ts.clear();
	}
	
	
	
	
	
}
