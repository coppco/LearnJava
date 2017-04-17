package com.github.model;

public class Student {
	private String name;
	private float chinese;
	private float english;
	private float math;
	private float total;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getChinese() {
		return chinese;
	}
	public void setChinese(float chinese) {
		this.chinese = chinese;
	}
	public float getEnglish() {
		return english;
	}
	public void setEnglish(float english) {
		this.english = english;
	}
	public float getMath() {
		return math;
	}
	public void setMath(float math) {
		this.math = math;
	}
	public float getTotal() {
		return (float) ((this.chinese + this.math + this.english) / 3.0);
	}
	public Student(String name, float chinese, float english, float math) {
		super();
		this.name = name;
		this.chinese = chinese;
		this.english = english;
		this.math = math;
	}
	public Student() {
		super();
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", chinese=" + chinese + ", english="
				+ english + ", math=" + math + ", total=" + total + "]";
	}
	
}
