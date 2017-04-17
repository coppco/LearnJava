package com.github.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.github.bean.Car;

public class Demo2_Entry {
	public static void main(String[] args) {
		Map<Car, String> map = new HashMap<>();
		map.put(new Car("red", 134.333f), "redCar");
		map.put(new Car("blue", 8989.98f), "blueCar");
	 	map.put(new Car("purple", 32423.22f), "purpleCar");
		
		//System.out.println(map);
		
		//增强for循环
		for (Car car : map.keySet()) {
			System.out.println(map.get(car));
		}
		System.out.println("------------");
		
		//keySet的迭代器
		Set<Car> set = map.keySet();
		Iterator<Car> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(map.get(it.next()));
			
		}
		System.out.println("------------");
		Set<Map.Entry<Car, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Car, String>> entryIt = entrySet.iterator();
		while (entryIt.hasNext()) {
			Map.Entry<Car, String> keyValue = entryIt.next();
			Car key = keyValue.getKey();
			String value = keyValue.getValue();
			System.out.println(value + key);
		}
		System.out.println("------------");
		for (Map.Entry<Car, String> entry : map.entrySet()) {
			System.out.println(entry.getValue() + entry.getKey());
		}
	}
	
}
