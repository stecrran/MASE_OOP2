package com.fork.join;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {

	private final int threshold;
	private final int[] myArray;
	private int start;
	private int end;

	public RandomArrayAction(int[] myArray, int start, int end, int threshold) {
		super();
		this.threshold = threshold;
		this.myArray = myArray;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start < threshold) {
			for (int i = start; i <= end; i++) {
				myArray[i] = ThreadLocalRandom.current().nextInt();
			}
		} else {
			int midway = (end - start)/2 + start;
			RandomArrayAction leftHalf = new RandomArrayAction(myArray, start, midway, threshold);
			RandomArrayAction rightHalf = new RandomArrayAction(myArray, midway + 1, end, threshold);
			
			invokeAll(rightHalf, leftHalf);
		}
	}

}
