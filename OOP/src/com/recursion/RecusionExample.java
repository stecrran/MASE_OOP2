package com.recursion;

class SimpleRecursion {
	public void foo(int x) {
		if (x > 0) {
			System.out.print(x);
			foo(x-1);
			
			System.out.print(x);
		}
	}
	
}


public class RecusionExample {
	
	public static void main(String[] args) {
		new SimpleRecursion().foo(5);
	}


}


