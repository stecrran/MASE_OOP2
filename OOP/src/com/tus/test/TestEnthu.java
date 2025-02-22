package com.tus.test;

public class TestEnthu {

	public static void main(String[] args) {
		int x = 0, y = 0;
		int y1 = (x = 2) + (x++) * (x = x * 5);
		int y2 = (x = 2) + (++x) * (x = x * 5);

		System.out.println("when x++, y= " + y1 + ", x= " + x);
		System.out.println("when ++x, y= " + y2 + ", x= " + x);
		
		int k = 5;
		for (int i = 0; i < 3; i++) {
			k = k + i;
			System.out.println("i = " + i + ", k = " + k);
		}
		System.out.println(k);
		Short num = new Short((short)1);
		
		int[] a = new int[10];
		for (int numbers : a) {
		System.out.println(numbers);
		}
	}

}
