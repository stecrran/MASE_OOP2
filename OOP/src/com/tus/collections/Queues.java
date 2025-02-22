package com.tus.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
	
	public static void main(String[] args) {
		Comparator<Book> comparatorPrice = Comparator.comparing(Book::getPrice);
		Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);
		
		booksByPrice.add(new Book("Java", 55.0));
		booksByPrice.add(new Book("Python", 23.0));
		booksByPrice.add(new Book("C++", 99.0));
		
		System.out.println("Ordering by price:");
		Iterator itMoreBooks = booksByPrice.iterator();
		
		while(itMoreBooks.hasNext()) {
			Book book = booksByPrice.poll();
			System.out.println(book);
		}
	}
}
