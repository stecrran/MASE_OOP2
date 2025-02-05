package com.tus.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {

	public static void main(String[] args) {
		BasicLambdas lambdas = new BasicLambdas();
		//lambdas.consumer();
		//lambdas.supplier();
		//lambdas.predicate();
		
		// check() method is static so now instance (lambdas) of Object
//		System.out.println("Predicate check(7): " + check(7, i -> i % 2 == 0));
//		System.out.println("Predicate check(4): " + check(4, i -> i % 2 == 0));
//		
//		Predicate<String> predicateString = s -> s.startsWith("Mr."); // you don't need to declare the lambda beforehand
//		System.out.println("Mr. Joe Bloggs: " + check("Mr. Joe Bloggs: ", predicateString));
//		System.out.println("Ms. Ann Bloggs: " + check("Ms. Ann Bloggs: ", s -> s.startsWith("Mr.")));
//		
//		//Predicate<Person> predicatePerson = p -> p.getAge() >= 18; // you could do this but the compiler can infer type (see below)
//		Person mike = new Person("Mike", 33, 1.8);
//		Person ann = new Person("Ann", 13, 1.4);
//		System.out.println("Mike is Adult? " + check(mike, p -> p.getAge() >= 18));
//		System.out.println("Ann is Adult? " + check(ann, p -> p.getAge() >= 18));
		
		//lambdas.function();
		
		List<Person> listPeople = getPeople();
		sortAge(listPeople);
		System.out.println();
		sortName(listPeople);
		System.out.println();
		sortHeight(listPeople);
		
		
	}
	
//	public void consumer() {
//		// using lambda
//		Printable<String> lambdaPrintable = s -> System.out.println(s);
//		lambdaPrintable.print("Printable lambda");
//		
//		// using Method Reference
//		Printable<String> MRPrintable = System.out::println;
//		MRPrintable.print("Printable Method Reference");
//		
//		// using Consumer directly
//		Consumer<String> lambdaConsumerPrintable = s -> System.out.println(s);
//		lambdaConsumerPrintable.accept("Printable lambda");
//
//	}
	
//	public void supplier() {
//		// using lambda
//		Retrievable<Integer> lambdaRetrieve = () -> 77;
//		System.out.println(lambdaRetrieve.retrieve());
//		
//		// using Supplier
//		Supplier<Integer> supplierRetrieve = () -> 77;
//		System.out.println(supplierRetrieve.get());
//	}
//	
//	public void predicate() {
//		// using lambda
//		Evaluate<Integer> lambdaEvaluate = s -> s < 0;
//		System.out.println(lambdaEvaluate.isNegative(-1));
//		System.out.println(lambdaEvaluate.isNegative(1));
//		
//		// using Predicate
//		Predicate<Integer> predicateRetrieve = s -> s < 0;
//		System.out.println(predicateRetrieve.test(-1));
//		System.out.println(predicateRetrieve.test(1));
//		
//	}
	
//	public static <T> boolean check(T value, Predicate<T> predicate) {
//		return predicate.test(value);
//	}
	
//	public void function() {
//		Functionable<Integer, String> functionableTest = i -> "Number is " + i;
//		System.out.println("Using Functionable: " + functionableTest.applyThis(25));
//		
//		// using Function
//		Function<Integer, String> functionTest = i -> "Number is " + i;
//		System.out.println("Using Function: " + functionTest.apply(25));
//
//	}
//	
	private static void sortName(List<Person> people) {
		people.sort(Comparator.comparing(p -> p.getName()));
		//people.sort(Comparator.comparing(Person::getName));
		
		System.out.println("After Sort by Name");
		people.forEach(System.out::println);
	}
//	
	private static void sortAge(List<Person> people) {
		//people.sort(Comparator.comparing(p -> p.getAge())); 
		people.sort(Comparator.comparing(Person::getAge));
		
		System.out.println("After Sort by Age");
		people.forEach(s -> System.out.println(s));
	}
	
	private static void sortHeight(List<Person> people) {
		//people.sort(Comparator.comparing(p -> p.getHeight()));
		people.sort(Comparator.comparing(Person::getHeight));
		
		System.out.println("After sorting by Height");
		people.forEach(System.out::println);
	}
	
	private static List<Person> getPeople(List<Person> people) {
		return people;
	}
	
    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }


	
}
