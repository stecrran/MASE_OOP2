package com.tus.taginterface;

import java.util.ArrayList;
import java.util.List;

class Animal {

}

class Cow extends Animal implements Tag {
	
}

class Sheep extends Animal implements Tag {
	
}

class Dog extends Animal {
	
}


public class TagTest {
	public static void main(String[] args) {
		Cow c = new Cow();
		Sheep s = new Sheep();
		Dog d = new Dog();
		
		if (c instanceof Tag) {
			System.out.println("Check this animal - Cow");
		}
		if (s instanceof Tag) {
			System.out.println("Check this animal - Sheep");
		}
		if (d instanceof Tag) {
			System.out.println("Check this animal - Dog");
		}
		System.out.println();
		
		Animal daisy = new Cow();
		Animal cybil = new Sheep();
		Animal tyson = new Dog();
		
		checkOne(c);
		checkOne(s);
		checkOne(d);
		System.out.println();
		checkOne(daisy);
		checkOne(cybil);
		checkOne(tyson);
		
		System.out.println();
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(c);
		animals.add(s);
		animals.add(d);
		TagTest.checkAll(animals);
	}

	public static void checkOne(Animal animal) {
		if (animal instanceof Tag) {
			System.out.println("checkOne" + animal.getClass().getSimpleName());
		}
	}

	public static void checkAll(ArrayList<Animal> animals) {
		for (Animal animal : animals) {
			if (animal instanceof Tag) {
				System.out.println("CheckAll - " + animal.getClass().getSimpleName());
			}
		}
	}
}
