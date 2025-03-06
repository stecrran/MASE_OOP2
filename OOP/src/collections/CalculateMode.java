package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateMode {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter number of data items: ");
		int n = sc.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();
		int highestFrequency = populateMap(n, map);
		for (Integer key : map.keySet()) {
			if (map.get(key) == highestFrequency) {
			System.out.println("Highest Frequency:\nThe number " + key + " appears " + highestFrequency + " times.");
			}
		}
	}

	public static int populateMap(int numberOfItems, Map<Integer, Integer> map) {
		int highestFreq = 0;
		System.out.println("Enter the data ");
		while (numberOfItems > 0) {
			int n = sc.nextInt();

			if (map.containsKey(n)) {
				int currentValue = map.get(n);
				map.put(n, currentValue + 1);
			} else {
				map.put(n, 1);
			}
			if (map.get(n) > highestFreq) {
				highestFreq = map.get(n);

			}
			numberOfItems--;
		}
		return highestFreq;
	}
}
