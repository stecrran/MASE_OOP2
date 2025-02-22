package com.tus.collections;

public class Book {
	private String name;
	private double price;
	
	public Book(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + "\t" + getPrice();
	}
	
	
	
}
