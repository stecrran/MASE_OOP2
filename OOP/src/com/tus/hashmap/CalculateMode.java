package com.tus.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateMode {

	private static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		System.out.print("Enter number of data items: > ");
		int n = sc.nextInt();
		
		Map<Integer, Integer> numberMap = new HashMap<>();
		int highestFreq = populateTheMap(n, numberMap);
		
		for (Integer num : numberMap.keySet()) {
			if (numberMap.get(num) == highestFreq) {
				System.out.println(num + " occurs " + highestFreq + " times.");
			}
		}
	}
	
	public static int populateTheMap(int numberOfDataItems, Map<Integer, Integer> numberMap) {
		int numToAdd = 0;
		int highestFreq = 0;
		
		// count all the numbers
		for (int i = 0; i < numberOfDataItems; i++) {
			System.out.print("Enter number: > ");
			numToAdd = sc.nextInt();
			
			if (numberMap.containsKey(numToAdd)) {
				numberMap.put(numToAdd, numberMap.get(numToAdd)+1);
			}
			else {
				numberMap.put(numToAdd, 1);
			}
			
			// check if highest frequency
			if (numberMap.get(numToAdd) > highestFreq) {
				highestFreq = numberMap.get(numToAdd);
			}
		}
		return highestFreq;
	}
}
