package com.tus.lab7;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
	private Map<String, Long> productCountMap = new HashMap<>();
    private Map<String, String> productNames = new TreeMap<>();

    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");

        // Create Product Counter Object and process data
        ProductCounter test = new ProductCounter(productNames);
        test.processList(parts);
        test.printReport();
    }

    public ProductCounter(Map<String, String> productNames) {
    	this.productNames = productNames;
    }

    public void processList(String[] list) {
        long currentValue = 0;
        for (String itemNumber : list) {
        	if (productCountMap.containsKey(itemNumber)) {
        		currentValue = productCountMap.get(itemNumber);
        		currentValue++;
        		productCountMap.put(itemNumber, new Long(currentValue));
        	}
        	else {
        		productCountMap.put(itemNumber, new Long(1));
        	}
        }
    }

    public void printReport() {
        System.out.println("--- Product Report ---");
        for (String key : productNames.keySet()) {
        	System.out.print("\nName: " + key);
        	System.out.print("\t| Count: " + productCountMap.get(productNames.get(key)));
        }
    }
}

