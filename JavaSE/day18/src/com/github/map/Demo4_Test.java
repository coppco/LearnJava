package com.github.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Demo4_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//扑克牌
		
		String[] nums = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] colors = {"♠","♥","♣","♦"};
		ArrayList<Integer> list = new ArrayList<>(); //索引
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//添加牌
		int i = 0;
		for (String number : nums) {
			for (String color : colors) {
				map.put(i, number+color);
				list.add(i);
				i++;
			}
		}
		map.put(i, "小王");
		list.add(i);
		map.put(++i, "大王");
		list.add(i);
		
		/*System.out.println(list);
		System.out.println(map);*/
		
		//洗牌
		Collections.shuffle(list);
//		System.out.println(list);
		
		//发牌
		
		TreeSet<Integer> ts1 = new TreeSet<>(); 
		TreeSet<Integer> ts2 = new TreeSet<>(); 
		TreeSet<Integer> ts3 = new TreeSet<>(); 
		TreeSet<Integer> dipai = new TreeSet<>(); 
		
		for (int j = 0; j < list.size(); j++) {
			if (j >= list.size() - 3) {
				dipai.add(list.get(j));
			} else if (j % 3 == 0){
				ts1.add(list.get(j));
			} else if (j % 3 == 1){
				ts2.add(list.get(j));
			} else if (j % 3 == 2){
				ts3.add(list.get(j));
			}
		}
		
		seaPoker(map, ts1);
		seaPoker(map, ts2);
		seaPoker(map, ts3);
		seaPoker(map, dipai);
	}

	public static void seaPoker(Map<Integer, String> map,TreeSet<Integer> ts) {
		for (Integer integer : ts) {
			System.out.print(map.get(integer) + "  ");
		}
		System.out.println();
	}

}
