package project;

import java.util.Random;

public class Tester {
	
	public static void main(String[] args) {
		HistogramFirstAttempt hh = new HistogramFirstAttempt();
		
		Random rand = new Random();
		
		int [] array = new int [1000000];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		
		//hh.printArray(array);
		//System.out.println("***");
		int[][] hist = hh.histogram(array);
		hh.printArray(hist);
	}

}
