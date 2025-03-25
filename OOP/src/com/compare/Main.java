package com.compare;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.compare.Code.Person;

//Main class
public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     boolean running = true;

     while (running) {
         System.out.println("Select an option:");
         System.out.println("1. Sorting & Grouping");
         System.out.println("2. Generics & Collections");
         System.out.println("3. Streams");
         System.out.println("4. Exit");
         System.out.print("Enter choice: ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 List<Person> people = Arrays.asList(
                         new Code.Person("Anne", "Bloggs", 45),
                         new Code.Person("Brian", "Smith", 18),
                         new Code.Person("Enda", "O'Neil", 20),
                         new Code.Person("David", "Jones", 19));
                 Collections.sort(people);
                 people.forEach(System.out::println);
                 break;
             case 2:
                 Code.MapsToMaps.generateMap();
                 break;
             case 3:
                 Code.StreamOperations.processStream();
                 break;
             case 4:
                 running = false;
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid choice, try again.");
         }
     }
     scanner.close();
 }
}



