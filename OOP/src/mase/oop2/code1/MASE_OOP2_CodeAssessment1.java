// Name: Stephen Curran
package mase.oop2.code1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import java.util.Comparator;

import mase.oop2.code1.Student;

public class MASE_OOP2_CodeAssessment1  {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int SORTING = 1, COLLECTIONS = 2, STREAMS = 3, EXIT = 4;
        String userContinue = "y";

        while (userContinue.equalsIgnoreCase("y")) {
            switch (userChoice()) {
                case SORTING:
                    sorting();
                    break;
                case COLLECTIONS:
                    collections();
                    break;
                case STREAMS:
                    streams();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    userContinue = "n";
                    break;
                default:
                    System.out.println("Unknown entry : ");
                    break;
            }
        }
    }

    public static void streams(){
        List<Student> students = Arrays.asList(
                                    new Student("A. Bloggs", "A011", 22, 2.0 ),
                                    new Student("B. Bloggs", "A012", 19, 1.9 ),
                                    new Student("E. Bloggs", "A010", 20, 2.1 ),
                                    new Student("D. Bloggs", "A009", 19, 1.8 ),
                                    new Student("C. Bloggs", "A013", 20, 1.7 )
        );
        // A 
    	students.stream().sorted((o1,o2) -> o1.getId().compareTo(o2.getId()))
		.forEach(s -> System.out.println(s.getId()+" "+s.getName())); 

        // B
        Map<Integer, List<String>> groupedByAge = students.stream()
        		.collect(Collectors.groupingBy(
        				s -> s.getAge(),
        				Collectors.mapping(s -> s.getName(), Collectors.toList())
        				));
        		
        groupedByAge.forEach((age, names) ->
        	System.out.println(age + " -> " + names)
        	);
        
        // C
        double avgHeight = students.stream()
        		.mapToDouble(s -> s.getHeight())
        		.filter(h -> h >= 2.0)
        		.average().orElse(0.0);
        
        System.out.println("Average height: " + avgHeight);
        
//        if (avgHeight.isPresent()) {
//        	System.out.println("Average height: " + avgHeight);
//        }
//        else {
//        	System.out.println("Empty Optional");
//        }

        
        // D
		Map<Integer, Double> studentMap = students.stream()
		.collect(Collectors.toMap((s -> s.getAge()), s -> s.getHeight(), (v1, v2) -> v1+v2));
		studentMap.forEach((a, b) -> System.out.println(a+" "+b));

        // E
       students.stream()
        .map(s -> s.getName())
        		.forEach(s -> System.out.print(s+" "));
       System.out.println();
    }

    public static void collections() {
        Map<String, Integer> makeToSales    = new TreeMap<>(); // make, sales
        Map<String, String> makeToCountry   = new TreeMap<>(); // make, country
        Map<String, Integer> salesByCountry = new TreeMap<>(); // country, sales

        // make -> sales
        // K -> V1
        makeToSales.put("Ford", 20_000); 
        makeToSales.put("Chevrolet", 5_000); 
        makeToSales.put("VW", 30_000); 
        makeToSales.put("Mercedes", 10_000); 
        makeToSales.put("BMW", 9_000); 
        makeToSales.put("Nissan", 15_000); 
        
        // make -> country
        // K -> V2
        makeToCountry.put("Ford", "USA");
        makeToCountry.put("Chevrolet", "USA");
        makeToCountry.put("VW", "Germany");
        makeToCountry.put("Mercedes", "Germany");
        makeToCountry.put("BMW", "Germany");
        makeToCountry.put("Nissan", "Japan");

        // a. Setup "salesByCountry"
        makeToSales.forEach((make, totalSales) -> {
        	String countrySales = makeToCountry.get(make);
        	if (salesByCountry.containsKey(countrySales)) {
        		int currentSales = salesByCountry.get(countrySales);
        		int newSales = currentSales + totalSales;
        		salesByCountry.put(countrySales, newSales);
        	}
		 else {
			salesByCountry.put(countrySales, totalSales);
		 }
        });
        
        
        // b. Output "salesByCountry"
        salesByCountry.forEach((country, sales) -> {
			System.out.println("Country: " + country + " numSales: " + sales);
		});

        // c. What country has the most/least sales?
	   	int min = Collections.min(salesByCountry.values());
	   	int max = Collections.max(salesByCountry.values());
	   	
	   	salesByCountry.forEach((country, sales) -> {
	   		if (salesByCountry.get(country) == max) {
	   			System.out.println("Country with the most sales: " + country + " " + sales);
	   		}
	   		else if (salesByCountry.get(country) == min){
	   			System.out.println("Country with the least sales: " + country + " " + sales);
	   		}
	   	});
     }

    public static void sorting(){
        List<Student> students = Arrays.asList(
                                    new Student("A. Bloggs", "A011", 22, 2.0 ),
                                    new Student("B. Bloggs", "A012", 19, 1.9 ),
                                    new Student("E. Bloggs", "A010", 20, 2.1 ),
                                    new Student("D. Bloggs", "A009", 19, 1.8 ),
                                    new Student("C. Bloggs", "A013", 20, 1.7 )
        );
        
        // b.
        Collections.sort(students, Comparator.comparing(s -> s.getId()));
        
        // c.
        students.forEach(s -> System.out.println(s));
        
        // d.
        Collections.sort(students, Comparator.comparing(s -> s.getName()));
        
        // e.
        students.forEach(s -> System.out.println(s));

    }
    public static int userChoice() {
        System.out.println("What do you want to do ?");
        System.out.println("1. Sorting");
        System.out.println("2. Collections");
        System.out.println("3. Streams");
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }






}
