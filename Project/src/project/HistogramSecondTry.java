package project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HistogramSecondTry {
	
	public void add (int key, Map<Integer, Integer> map){
		
		Integer value = map.get(key);
		
		if (value == null){
			map.put(key, 1);
		}else{
			map.put(key, value + 1);
		}
	}
	
	public int[][] histogram(int[] array){
		Map<Integer, Integer> map = new HashMap<>(256, 0.5f);
		
		System.out.println("HashMap approach: ");
		
		
		//cataloging work starts here
		long time = System.currentTimeMillis();
		for (int number : array) 
			add(number, map);
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - time) + "milliseconds");
		
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		
		int [][] histogram = new int[map.size()][2];
		for (int index = 0; index < map.size(); index++) {
			Entry<Integer, Integer> entry = iterator.next();
			histogram[index][0] = entry.getKey();
			histogram[index][1] = entry.getValue();
		} 
		
		return histogram;
	}
	
	public void printArray( int [][] array){
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i][0] + "\t" + array[i][1]);
		}
	}
	
	public void printArray( int [] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
			if ((i + 1)%20 == 0){
				System.out.println();
			}
		}
	}
}
