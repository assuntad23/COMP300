package rbtrees;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		
		TreeMap<Integer, String> tmap = new TreeMap<>();
		
		tmap.put(1, "Assunta");
		tmap.put(2, "Lucian");
		tmap.put(3, "Grammie");
		tmap.put(4, "Grampa");
		tmap.put(5, "Nana");
		
		if (tmap.containsKey(3)){
			System.out.println("Key 3 is contained in map");
			System.out.println("Value is: " + tmap.get(3));
		}
		
		if (tmap.containsValue("Assunta")){
			System.out.println("Assunta is contained in map");
		} 
		
		Set<Entry<Integer, String>> entrySet = tmap.entrySet();
		Iterator<Entry<Integer, String>> iter = entrySet.iterator();
		
		while(iter.hasNext()){
			Entry<Integer, String> entry = iter.next();
			System.out.println("Key : " + entry.getKey());
			System.out.println("Value : " + entry.getValue());
			System.out.println("---");
		}
	}

}
