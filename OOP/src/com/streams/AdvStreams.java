package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvStreams {

	public static void main(String[] args) {
		// Q1
		//List<Integer> numberInt = Arrays.asList(0, 1, 2, 3, 4); // not int primitive
				
		OptionalDouble average = IntStream.range(0, 5).average();
		if (average.isPresent()) {
			System.out.println("Average: " + average.getAsDouble());
		}
		else {
			System.out.println("Empty Optional.");
		}
		
        IntStream is2 = IntStream.rangeClosed(0,5); //0..5
        //is2.forEach(System.out::println); 

        // This is why it returns OptionalDouble and not double
        OptionalDouble avg    = IntStream.range(0,0).average();
        System.out.println(avg);// OptionalDouble.empty
        
        IntStream is3  = IntStream.range(0, 0);    // 0,1,2,3,4 = 5 numbers
        double avg2    = is3.average().orElse(0);  // 0+1+2+3+4 = 10/5 = 2.0
        System.out.println(avg2);
		
        // Q2
		List<Item> items = Arrays.asList(
				new Item(1, "Screw"),
				new Item(2, "Nail"),
				new Item(3, "Bolt")
				);
		
		// Different options
		System.out.println("\nNormal order:");
		items.stream().sorted((a,b) -> a.getId().compareTo(b.getId()))
		.forEach(System.out::print); // 1,2,3 = ScrewNailBolt
		
		System.out.println("\n\nReverse order:");
		items.stream().sorted((b,a) -> a.getId().compareTo(b.getId()))
		.forEach(System.out::print); // 3,2,1 = BoltNailScrew
		
		System.out.println("\n\nUsing Comparator:");
		items.stream().sorted(Comparator.comparing(a -> a.getName()))
		.map(item -> item.getName()) // or .map(Item::getName)
		.forEach(System.out::print); // Sorted by name, as we wanted. Output: BoltNailScrew  
		
		System.out.println("\n\nAlternative sort:");
		items.stream()
		.map(i -> i.getName())
		.sorted()  // sort by the String's natural order
		.forEach(i -> System.out.print(i)); // Sorted by name, as we wanted. Output: BoltNailScrew 
		
		// Q3
		Stream<List<String>> streamOfLists = Stream.of (
				Arrays.asList("a", "b"),
				Arrays.asList("a", "c")
				);

		streamOfLists
		.filter(list -> list.contains("c"))
		.flatMap(list -> list.stream())
		.forEach(str -> System.out.print(str));
				
		List<String> list = Arrays.asList("a", "b", "c");
		list.forEach(s -> System.out.println(s)); // Consumer == void accept(T t)
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
		
		// Q4
		List<Integer> numbers = Arrays.asList(1,2,3);
		
		Integer sum = numbers.stream()
				.mapToInt(i -> i)
				.sum();
		System.out.println("Sum = " + sum);
		
		OptionalInt max = numbers.stream()
				.mapToInt(i -> i)
				.max();
		System.out.println("Max = " + max);
		
		Integer max = numbers.stream()
				.mapToInt(i -> i.intValue()).max().getAsInt();
		System.out.println("Max = " + max);
		
		List<Person> persons = Arrays.asList(
				new Person("Alan", "Burke", 22),
				new Person("Zoe", "Peters", 20),
				new Person("Peter", "Castle", 29)
				);
		
		Person oldest = persons.stream()
		.max(Comparator.comparing(p -> p.getAge()))
				.get();
		System.out.println("Oldest is " + oldest.getFirstName());
		
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> OptInt = nums.stream()
				.max(Comparator.comparing(i -> i));
		
		List<Integer> nums = Arrays.asList(10, 47, 33, 23);
		
		// Optional<T> reduce(BinaryOperator<T> accumulator)
		int max2 = nums.stream()
				.reduce((a, b) -> Integer.max(a,b))
				.get();
		System.out.println("Max2 = " + max2);
		
		// T reduce(T identity, BinaryOperator<T> accumulator)
		int max3 = nums.stream()
				.reduce(Integer.MIN_VALUE, (a,b) -> Integer.max(a,b));
		System.out.println("Max3 = " + max3);
	
	
	// Q5
	
	// Q6
	List<Book> books = Arrays.asList(
			new Book("Thinking in Java", 30.0),
			new Book("Java in 24 hrs", 20.0),
			new Book("Java Recipes", 10.0)
			);
	
	double avgPriceBook = books.stream()
	.filter(b -> b.getPrice() > 50)
	.mapToDouble(b -> b.getPrice())
	.average()
	//.getAsDouble()
	.orElse(0.0); // useful if nothing is returned
	
	System.out.println(avgPriceBook);
	
	// Q7
	List<Book> books = Arrays.asList(
			new Book("Atlas Shrugged", 10.0),
			new Book("Freedom at Midnight", 5.0),
			new Book("Gone with the Wind", 5.0)
			);
	
	Map<String, Double> bookMap = books.stream()
			.collect(Collectors.toMap((b -> b.getTitle()), (b -> b.getPrice())));
	
	BiConsumer<String, Double> biConFunction = (a,b) -> {
		if (a.startsWith("A")) {
			System.out.println(b);
		}
	};
	
	bookMap.forEach(biConFunction);
	
//	// Q8
		List<Book> books = Arrays.asList(
		new Book("Gone with the wind", 50.0),
		new Book("Gone with the wind", 10.0),
		new Book("Atlas Shrugged", 15.0)
		);
		
		Map<String, Double> bookMap = books.stream()
		//.collect(Collectors.toMap((b -> b.getTitle()), (b -> b.getPrice()))); // leads to IllegalStateException (Duplicate Keys)
		.collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice(), (v1, v2) -> v1*v2));
		bookMap.forEach((a, b) -> System.out.println(a + " " + b)); 
				
	// Q9
        List<Person> friends = 
        		Arrays.asList(  
                new Person("Bob", "Kelly", 31),
                new Person("Paul", "Landers", 32),                                 
                new Person("John", "Paters", 33)); 
        double averageAge = friends.stream()
        // Stream<Person> filter(Predicate)
        .filter(person->person.getAge()<30)     
        // IntStream mapToInt(ToIntFunction)
        //    ToIntFunction
        //       int applyAsInt(T t)
        .mapToInt(person->person.getAge())   
        // OptionalDouble average()
        .average()  
        //.getAsDouble(); // NoSuchElementException: No value present
         .orElse(0.0);//0.0
        System.out.println(averageAge); 
		
		
	// Q10
		
		
		
     // Q11
        List<AnotherBook> books = Arrays.asList(  
                new AnotherBook("Gone with the wind", "Fiction"),        
                new AnotherBook("Bourne Ultimatum", "Thriller"),         
                new AnotherBook("The Client", "Thriller") );  
        List<String> genreList = new ArrayList<>(); 
        books.stream()
//            .map(book -> book.getGenre())     // lambda
            .map(AnotherBook::getGenre)       // method reference
//                .map(                           // anonymous inner class
//                    new Function(){
//                        @Override
//                        public String apply(Object o){
//                            return ((AnotherBook)o).getGenre();
//                        }
//                    } 
//                )
//            .forEach(s->genreList.add(s));    // lambda
            .forEach(genreList::add);         // method reference (bound)
//            .forEach(ArrayList::add);         // does not compile!
//                .forEach (                      // anonymous inner class
//                    new Consumer(){
//                        @Override
//                        public void accept(Object o){
//                            genreList.add((String)o);
//                        }
//                    }
//                );
        System.out.println(genreList);
    
        
	
	// Q12
    // 1. sum()
    DoubleStream is = DoubleStream.of(0, 2, 4); //1 
    double sum = is.filter( i->i%2 != 0 ).sum(); // sum() is a terminal operation (reduction also) 
    System.out.println("sum is "+sum); // 0.0

    // 2. average()
    OptionalDouble od = Stream.of(1.0,3.0)
            // DoubleStream mapToDouble(ToDoubleFunction)
            //      ToDoubleFunction
            //          double applyAsDouble(T value);
                            .mapToDouble(n->n.doubleValue())
                            .filter(n -> n%2 == 0)
                            .average();// terminal operation (reduction also)
    if(od.isPresent()){
        System.out.println("average == "+od.getAsDouble());
    }
    
    // Q13
    List<Integer> ls = Arrays.asList(11, 12, 22, 33, 33, 55, 66);
    
    // 1. distinct()
    System.out.println("distinct");
    ls.stream()
        .distinct()
        .forEach(n -> System.out.println(n));  // 11, 22, 33, 55, 66
    // Java only generates the amount of stream you need (lazy evaluation).
    System.out.println("\nanyMatch");
    System.out.println(ls.stream()
                        .distinct()
                        .peek(System.out::println)
                        .anyMatch(x -> x==11));// true
    
    System.out.println("\nnoneMatch");
    System.out.println(ls.stream()
                        .peek(System.out::println)
                        .noneMatch(x -> x%11>0));// true
    
    // Q14
  AtomicInteger ai = new AtomicInteger(); // initial value of 0
  Stream.of(11, 11, 22, 33)
          .parallel()
          .filter(n -> {
              ai.incrementAndGet();
              return n % 2 == 0;
          })
          .forEach(System.out::println);//22
  System.out.println(ai);//4

//1 of 2
  AtomicInteger ai = new AtomicInteger(); // initial value of 0
  Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
  stream.filter( e->{     
      ai.incrementAndGet();     
      return e%2==0; }); 
  stream.forEach(System.out::println);// java.lang.IllegalStateException
  System.out.println(ai);

//2 of 2
	  AtomicInteger ai = new AtomicInteger(); // initial value of 0
	  Stream<Integer> stream = Stream.of(11, 11, 22, 33, 34).parallel();
	  Stream<Integer> stream2 = stream.filter( e->{     
	      ai.incrementAndGet();     
	      return e%2==0; }); 
	  stream2.forEach(System.out::println);// 22
	  System.out.println(ai);
    
}
        
}
  
        


