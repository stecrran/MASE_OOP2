package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestMapping {

	public static void main(String[] args) {
//		Consumer<String> printC = s -> System.out.println(s);
//		printC.accept("To be or not to be, that is the question.");
//
//		List<String> names = new ArrayList<>();
//		names.add("Maaike");
//		names.add("Sean");
//		names.forEach(printC);
		
		Map<String, String> mapCapitalCities = new HashMap<>();
		BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
		
		biCon.accept("Dublin", "Ireland");
		biCon.accept("The Hague", "Holland");
		System.out.println(mapCapitalCities);
		
		BiConsumer<String, String> mapPrint = (key, value) -> 
		System.out.println(key + " is the capital of " + value);
		
		mapCapitalCities.forEach(mapPrint);
		
		
	}
}
