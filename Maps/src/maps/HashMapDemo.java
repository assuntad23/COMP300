package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<>(); // (initial capacity, load factor-Float) to set these values
		
		map.put(01, "Assunta");
		map.put(02, "Noah");
		map.put(03, "Lucian <3");
		map.put(04, "Peter");
		map.put(05, "Aurora");
		
		
		System.out.println(map.get(3));
		
		map.remove(04);
		System.out.println(map.get(4));
		
		System.out.println(map.size());
		
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Entry<Integer, String>> iter = entrySet.iterator();
		
		while(iter.hasNext()){
			Entry<Integer, String> entry = iter.next();
			System.out.println("Key : " + entry.getKey());
			System.out.println("Value : " + entry.getValue());
			System.out.println("---");
		}
	}

}
