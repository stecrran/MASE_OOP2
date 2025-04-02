package com.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice {

	public static void main(String[] args) {
//		List<Purchase> purchases = Arrays.asList(
//				new Purchase("Shirt", 100.1),
//				new Purchase("Shoes", 149.9),
//				new Purchase("Jumper", 90.3)
//				);
//		
//		//OptionalDouble avgPrice = purchases.stream().mapToDouble(p -> p.getPrice()).filter(p -> p > 100 && p < 200).average();
//		OptionalDouble avgPrice = purchases.stream().mapToDouble(p -> p.getPrice()).filter(p -> p > 10 && p < 20).average();
//		
//		if (avgPrice.isPresent()) {
//			System.out.println("Average Price: " + avgPrice);
//		}
//		else {
//			System.out.println("Empty Optional");
//		}

		// Adv. Streams Q1 -stream int primitives and get average
//		OptionalDouble average = IntStream.range(0, 5).average();
//		average.ifPresent(System.out::println); 
//		// or
//		average.ifPresent(avg -> System.out.println("Average: " + avg));

		// Q2
//		List<Item> items = Arrays.asList(
//				new Item(1, "Screw"),
//				new Item(2, "Nail"),
//				new Item(3, "Bolt")
//				);
//		
//		items.stream()
//		.sorted((a,b) -> a.getName().compareTo(b.getName())) // "sorted" not "sort"
//		.forEach(System.out::print);
//		System.out.println();
//		
//		// Q3
//		Stream<List<String>> streamLetters = Stream.of(
//						Arrays.asList("a", "b"), 
//						Arrays.asList("a", "c")
//						);
//		streamLetters.filter(list -> list.contains("c"))
//		.flatMap(list -> list.stream())
//		.forEach(System.out::println);

		// Q4
//		List<Integer> someNumbers = Arrays.asList(1, 2, 3);
//		int total = someNumbers.stream().
//		mapToInt(n -> n.intValue())
//		.sum();
//		System.out.println(total);
//		
////		int max = someNumbers.stream().
////		mapToInt(n -> n.intValue())
////		.max()
////		.orElse(-1);
////		System.out.println(max);
//		
//		OptionalInt max = someNumbers.stream().
//		mapToInt(n -> n.intValue())
//		.max();
//		System.out.println(max); // print as OptionalInt[]
//		max.ifPresent(System.out::println); // print value

//		List<Person> people = Arrays.asList(
//				new Person("Alan", "Burke", 22),
//				new Person("Zoe", "Peters", 20),
//				new Person("Peter", "Castle", 29));
//		
//		Person oldest = people.stream()
//		.max(Comparator.comparing(p -> p.getAge()))
//		.get();
//		System.out.println("Oldest is " + oldest.getFirstName());
//		
//		// or
//		Optional<Person> person = people.stream()
//				.max(Comparator.comparingInt(p -> p.getAge()));
//		person.ifPresent(p -> System.out.println("Oldest is " + p.getFirstName()));

//		List<Integer> nums = Arrays.asList(10, 47, 33, 23);
//		
//		// Optional<T> reduce(BinaryOperator<T> accumulator)
//		int max2 = nums.stream()
//				.reduce((a, b) -> Integer.max(a,b))
//				.get();
//		System.out.println("Max2 = " + max2);
//		
//		// T reduce(T identity, BinaryOperator<T> accumulator)
//		int max3 = nums.stream()
//				.reduce(Integer.MIN_VALUE, (a,b) -> Integer.max(a,b));
//		System.out.println("Max3 = " + max3);

		// Q5
		// b.i. grade1 for marks = 50
		Optional<String> grade1 = getGrade(50);

		// b.ii. grade2 for marks = 55
		Optional<String> grade2 = getGrade(55);

		// b.iii. Use orElse on grade1
		System.out.println("Grade 1: " + grade1.orElse("UNKNOWN"));

		// b.iv. If grade2 is present, print it using ifPresent(), else use orElse()
		if (grade2.isPresent()) {
			grade2.ifPresent(g -> System.out.println("Grade 2: " + g));
		} else {
			System.out.println("Grade 2: " + grade2.orElse("Empty"));
		}
	}

	// a. The getGrade method
	public static Optional<String> getGrade(int marks) {
		Optional<String> grade = Optional.empty(); // i. Declare an empty Optional

		if (marks > 50) {
			grade = Optional.of("PASS");
		} else {
			grade = Optional.of("FAIL"); // Corrected: was "grade.of(...)", should be Optional.of(...)
		}

		return grade;
	}

}
