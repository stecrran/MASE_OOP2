package com.tus.test;


public class Dog implements Moveable {
	
	@Override
	public void move() {
		System.out.println("Dog::move()");
	}
	
	public static void main(String[] args) {
		// HOW = "Walk"; 	// cannot be reassigned (HOW is static final)
		
		System.out.println(Moveable.HOW);
		System.out.println(HOW);
		
		// move(); 	// cannot use non-static call
		
		new Dog().move();
	}
}
