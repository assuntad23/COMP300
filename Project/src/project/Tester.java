package project;

import java.util.Random;

public class Tester {
	
	public static void main(String[] args) {
		HistogramFirstTry h1 = new HistogramFirstTry();
		HistogramSecondTry h2 = new HistogramSecondTry();
		
		Random rand = new Random();
		
		int [] array = new int [20];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
		}
		
		//hh.printArray(array);
		//System.out.println("***");
		int[][] hist1 = h1.histogram(array);
		h1.printArray(hist1);
		int[][] hist2 = h2.histogram(array);
		h2.printArray(hist2);
		
	}

}
