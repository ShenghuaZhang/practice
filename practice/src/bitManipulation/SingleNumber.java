package bitManipulation;

import java.util.HashSet;
import java.util.Set;
/**
 * 136
 * https://leetcode.com/problems/single-number/
 * 
 * Given an array of integers,
 * every element appears twice except for one. Find that single one.
 * 
 * @author yili3
 * 
 * #SingleNumberII
 *
 */
public class SingleNumber {
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
