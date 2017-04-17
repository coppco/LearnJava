package com.github.coppco;

import java.awt.Color;
import java.lang.reflect.Field;

public class Demo4_Tool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Car car = new Car("red");
		Tool.setProperty(car, "color", new Color(10));
		System.out.println(car.getColor());
	}

}

class Tool {
	private Tool() {}
	public static void setProperty(Object obj, String propertyName, Object value) {
		 try {
			Field field = obj.getClass().getField(propertyName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class Car {
	private String color;

	public Car() {
		super();
		
	}

	public Car(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
