package com.streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsLab {
	
	public static void main(String[] args) {
		
		//Stream.of("one", "two", "three")
		Stream.of("one", "one", "three")
			.peek(s -> System.out.println("1. " + s))
			.distinct()
			.forEach(s -> System.out.println("2. " + s));

		
		Map<Integer, String> map = Stream.of("cake", "biscuits", "tart")
				.collect(Collectors.toMap(s -> s.length(), s -> s, (s1, s2) -> s1 + "," + s2)
					);
		
		// 1
		List<Integer> numbers = Arrays.asList(9, 10, 13, 76, 8, -9);
		System.out.println("Number of numbers > 10 = " + numbers.stream().filter(n -> n > 10).count());

		// 2
		List<String> names = Arrays.asList("Andrew", "Brian", "Charlie", "Aaron", "Ed");
		System.out
				.println("Names = " + names.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("A")).count());

		// 3
		List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
		System.out.println("Temperatures greater than 100 = " + temps.stream().filter(d -> d > 100.0).count());

		// 4
		Map<String, Integer> dogs = new HashMap<>();
		dogs.put("Spot", 1);
		dogs.put("Rex", 4);
		dogs.put("Charlie", 8);

		System.out.println(
				"Number of dogs > 4yrs = " + dogs.entrySet().stream().filter(entry -> entry.getValue() > 4).count());

		// 5 - "names" already declared as List<String> for // 2
		names = Arrays.asList("Andrew", "Brian", "Charlie", "Aaron", "Ed", "Sean");
		boolean anyS = names.stream().map(s -> s.toUpperCase())
				.anyMatch(s -> s.startsWith("S"));

		if (anyS) { // stream() is a terminal operation, it needs to be re-run after it finishes
			System.out.println("Number of names beginning with 's' = "
					+ names.stream().map(s -> s.toUpperCase())
					.filter(s -> s.startsWith("S")).count());
		}
		else {
			System.out.println("No names begin with 's");
		}
		
		// 6
		List<Purchase> purchases = Arrays.asList(
						new Purchase("Shirt", 100.1),
						new Purchase("Shoes", 149.9),
						new Purchase("Jumper", 90.3));
		
		OptionalDouble avgPrice = purchases.stream()
				.mapToDouble(r -> r.getPrice())
				.filter(p -> p > 100.0 && p < 200.0)
				.average();
		
		System.out.println(avgPrice);

		if (avgPrice.isPresent()) {
			System.out.println("Average price: " + avgPrice.getAsDouble());
		} else {
			System.out.println("Empty Optional");
		}
		
		avgPrice = purchases.stream()
				.mapToDouble(purch -> purch.getPrice())
				.filter(p -> p > 10.0 && p < 20.0)
				.average();
		
		System.out.println(avgPrice);
		
		if (avgPrice.isPresent()) { // solves NoSuchElementException issue
			System.out.println("Average price: " + avgPrice.getAsDouble());
		} else {
			System.out.println("Empty Optional");
		}
		
	}
}
