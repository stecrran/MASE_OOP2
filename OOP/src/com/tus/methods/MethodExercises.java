package com.tus.methods;

import java.util.Scanner;

public class MethodExercises {

	static Scanner sc = new Scanner(System.in);

	private static final double MIN = 1;
	private static final double MAX = 8;

	public static void main(String[] args) {
		// MethodExercises.carPark();
//		System.out.print("How many number of numbers? > ");
//		int n = sc.nextInt();
//		System.out.println("The sum of the " + n + " values is " + MethodExercises.sumTheValues(n));
	
//		System.out.println("Square root = " + MethodExercises.square(7));
//		System.out.println("Square root = " + MethodExercises.square(7.5));
		
		System.out.print("Enter a value: ");
		int num1 = sc.nextInt();
		
		System.out.print("Enter a value: ");
		int num2 = sc.nextInt();
		
		MethodExercises MethodExercisesTest = new MethodExercises();
		System.out.println("Total of " + num1 + " and " + num2 + " is " + MethodExercisesTest.addNumbers(num1, num2));		
	}

	public static void carPark() {
		System.out.print("Enter number of cars > ");
		int cars = sc.nextInt();

		double parkTime = 0.0;
		double total = 0.0;
		for (int i = 0; i < cars; i++) {
			System.out.print("How many hours was car " + (i + 1) + " parked? > ");

			double hours = sc.nextDouble();
			System.out.println(
					"Car " + (i + 1) + " parked for " + hours + " hours, " + "and charged " + calculateCharges(hours));
		}
	}

	public static double calculateCharges(double hours) {
		double charge = 0.0;
		if (hours < MIN) {
			charge = 0.0;
		} else if (hours > MAX) {
			charge = 21.00;
		} else {
			charge = (Math.ceil(hours - 1) * 3.0);
		}

		return charge;
	}

	public static int sumTheValues(int number) {
		int total = 0;
		for (int i = 0; i < number; i++) {
			System.out.print("Enter a value: ");
			int value = sc.nextInt();
			total += value;
		}
		return total;
	}

	public static int square(int value) {
		return (int)Math.sqrt(value);
	}
	
	public static double square(double value) {
		return Math.sqrt(value);
	}

	public int addNumbers(int num1, int num2) {
		return num1 + num2;
	}
}
