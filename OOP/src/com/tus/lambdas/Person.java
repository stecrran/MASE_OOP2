package com.tus.lambdas;

public class Person {

	private Integer age;
	private String name;
	private Double height;
	
	Person(String name, Integer age, Double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public Double getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return "Person (age = " + getAge() + ", name = " + getName() + 
				", height = " + getHeight() + ")";
	}

//	@Override
//	public int compareTo(Person other) {
//		return Integer.compare(this.age, other.getAge());
//	}

}
