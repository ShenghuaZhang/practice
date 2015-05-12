package bitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T
 * for example: "ACGAATTCCG".
 * Write a function to find all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:	["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 */
public class RepeatedDNASequences {
	// best one
	public List<String> findRepeatedDnaSequences(String s){
		List<String> list = new ArrayList<>();
		if(s==null || s.length()<11)	return list;
		Map<Integer, Integer> map = new HashMap<>();
		int hashCode = 0;
		for(int i=0; i<10; i++)
		/* 'A' - 'A' + 1 = 1  = 1 (mod 5)
		 * 'C' - 'A' + 1 = 3  = 3 (mod 5)
		 * 'G' - 'A' + 1 = 7  = 2 (mod 5)
		 * 'T' - 'A' + 1 = 20 = 0 (mod 5)
		 * */
		hashCode = (hashCode<<2)|(s.charAt(i)-'A'+1)%5;
		map.put(hashCode, 0);
		for(int i=10; i<s.length(); i++){
			hashCode = ((hashCode<<2)^(((s.charAt(i-10)-'A'+1)%5)<<20)|(s.charAt(i)-'A'+1)%5);
			if(map.containsKey(hashCode)){
				if(map.get(hashCode)==0){
					list.add(s.substring(i-9, i+1));
					map.put(hashCode, 1);
				}
			}else map.put(hashCode, 0);
		}
		System.out.print(list);
		return list;
	}
	
	public List<String> findRepeatedDnaSequencesMine(String s){
		List<String> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
	
		for(int i=10; i<=s.length(); i++){
			int hashCode = hash(s, i);
			if(map.containsKey(hashCode)){
				if(map.get(hashCode)==0){
					list.add(s.substring(i-10, i));
					map.put(hashCode, 1);
				}
			}else map.put(hashCode, 0);
		}
		return list;
	}
	private int hash(String s, int index){
		int hashCode = 0;
		for(int i=index-10; i<index; i++)
			hashCode = hashCode*5 + (s.charAt(i)-'A');
		return hashCode;
	}
}
