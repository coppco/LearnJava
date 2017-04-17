package com.github.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo3_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String st = "abccbaabccbaaaabbbccc";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : st.toCharArray()) {
			/*if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}*/
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue() + "¸ö");
		}
	}

}
