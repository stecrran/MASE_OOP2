package com.compare;

import java.util.*;
import java.util.stream.Collectors;

//Code class containing all logic
class Code {
 // Sorting via Comparable (Natural Sort Order & Grouping)
 static class Person implements Comparable<Person> {
     private String firstName;
     private String lastName;
     private int age;

     public Person(String firstName, String lastName, int age) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.age = age;
     }

     public String getFirstName() {
         return firstName;
     }

     public String getLastName() {
         return lastName;
     }

     public int getAge() {
         return age;
     }

     @Override
     public int compareTo(Person p) {
         return Integer.compare(this.age, p.age);
     }

     @Override
     public String toString() {
         return firstName + " " + lastName + " (Age: " + age + ")";
     }
 }

 // Generics and Collections (Maps to Maps)
 static class MapsToMaps {
     public static void generateMap() {
         Map<String, Integer> studentScores = new HashMap<>();
         studentScores.put("Alice", 85);
         studentScores.put("Bob", 92);
         studentScores.put("Charlie", 78);
         studentScores.put("David", 92);

         Map<Integer, List<String>> groupedScores = studentScores.entrySet().stream()
                 .collect(Collectors.groupingBy(Map.Entry::getValue,
                         Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

         groupedScores.forEach((score, students) ->
                 System.out.println("Score " + score + ": " + students));
     }
 }

 // Streams (Advanced Streams Operations)
 static class StreamOperations {
     public static void processStream() {
         List<Person> people = Arrays.asList(
                 new Person("Anne", "Bloggs", 45),
                 new Person("Brian", "Smith", 18),
                 new Person("Enda", "O'Neil", 20),
                 new Person("David", "Jones", 19));

         // Finding the oldest person
         Optional<Person> oldest = people.stream().max(Comparator.comparing(Person::getAge));
         oldest.ifPresent(p -> System.out.println("Oldest Person: " + p));

         // Average age calculation
         double averageAge = people.stream().mapToInt(Person::getAge).average().orElse(0.0);
         System.out.println("Average Age: " + averageAge);
     }
 }
}