package com.generics;

import java.util.Arrays;
import java.util.Comparator;

public class Q16 {

	public static void main(String[] args) {
		String []s = {"a", "b", "d", "c"};
		Othello o = new Othello();
		Arrays.sort(s, o);
		for(String s2:s) System.out.println(s2 + " ");
	}
	
	static class Othello implements Comparator<String> {
		
		@Override
		public int compare(String b, String a) { return b.compareTo(a);}
	}
}
