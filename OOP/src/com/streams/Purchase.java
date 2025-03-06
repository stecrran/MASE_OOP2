package com.streams;

public class Purchase {
	
	private String item;
	private double price; // primitive 'double', not wrapper 'Double'
	
	public Purchase(String item, double price) {
		super();
		this.item = item;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public double getPrice() {
		return price;
	}
	
	

}
