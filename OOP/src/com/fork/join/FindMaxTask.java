package com.fork.join;

import java.util.concurrent.RecursiveTask;

// unchanged in solution...
// RecursiveTask<T> is generically typed and compute() returns T
//   T is Integer here
// Class ForkJoinTask<V> 
//      - is a parent of both RecursiveAction and RecursiveTask
//      - is an abstract base class for tasks that run within a ForkJoinPool. 
public class FindMaxTask extends RecursiveTask<Integer> {
	private final int threshold;
	private final int[] myArray;
	private int start;
	private int end;

	public FindMaxTask(int[] myArray, int start, int end, int threshold) {
		this.threshold = threshold;
		this.myArray = myArray;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		if (end - start < threshold) {
			int max = Integer.MIN_VALUE;
			for (int i = start; i <= end; i++) {
				int n = myArray[i];
				if (n > max) {
					max = n;
				}
			}
			return max;
		} else {
			int midway = (end - start) / 2 + start;
			FindMaxTask lowHalf = new FindMaxTask(myArray, start, midway, threshold);
			lowHalf.fork();// asynchronously execute this task.
			FindMaxTask topHalf = new FindMaxTask(myArray, midway + 1, end, threshold);
			// abstract V compute() - recursive call
			// V join() - returns the result
			// of the computation when it is done
			return Math.max(topHalf.compute(), lowHalf.join());
		}
	}
}