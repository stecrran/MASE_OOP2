package com.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class SteamsLab_Repeat {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(9, 10, 13, 76, 8, -9);
		System.out.println(numbers.stream().filter(n -> n > 10).count());
		
		List<String> names = Arrays.asList("Andrew", "Brian", "Charlie", "Aaron", "Ed");
		System.out.println("Name: " + names.stream().map(s -> s.toUpperCase())
				.filter(s -> s.startsWith("A")).count());
		
		List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
		System.out.println(temps.stream().filter(d -> d > 100).count());
		
		Map<String, Integer> dogs = new HashMap<>();
		dogs.put("Spot", 1);
		dogs.put("Rex", 4);
		dogs.put("Charlie", 8);
		
		System.out.println(dogs.entrySet().stream().filter(d -> d.getValue() > 4).count());
		
		List<String> nameOf = Arrays.asList("Andrew", "Brian", "Charlie", "Aaron", "Ed", "Sean");
		boolean test = nameOf.stream().map(s -> s.toUpperCase()).
				anyMatch(s -> s.startsWith("S"));
		
		if (test) {
			System.out.println(nameOf.stream().map(s -> s.toUpperCase()).
				filter(s -> s.startsWith("S")).count());
		}
		else {
			System.out.println("None begin with 'S'.");
		}
		
		List<Purchase> purchases = Arrays.asList(
				new Purchase("Shirt", 100.1),
				new Purchase("Shoes", 149.9),
				new Purchase("Jumper", 90.3));
		
		OptionalDouble avgPrice = purchases.stream().mapToDouble(r -> r.getPrice()).
				filter(p -> (p > 10 && p < 20)).average();
		
				
		if (avgPrice.isPresent()) {
			System.out.println("Average Purchase: " + avgPrice);
		}
		else {
			System.out.println("Empty Optional");
		}
	}
}
