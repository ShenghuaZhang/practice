package bitManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	
	// using hash map
	public static int singleNumberMap(int[] A){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i:A){
			int count = map.containsKey(i)?map.get(i)+1:1;
			map.put(i, count);
		}
		for(int i:A)
			if(map.get(i)==1)	return i;
		
		throw new IllegalArgumentException("No this single number");
	}
	
	// using hash set
	public static int singleNumberSet(int[] A){
		Set<Integer> set = new HashSet<>();
		for(int i:A){
			if(set.contains(i))	set.remove(i);
			else set.add(i);
		}
		return set.iterator().next();
	}
	
	// BEST: using XOR
	public static int singleNumbeXOR(int[] A){
		int rs = 0;
		for(int i:A)	rs^=i;
		return rs;
	}
}
