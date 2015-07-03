package BitManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 187
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author kajia
 * 
 * for yi's method, we will translate a letter multiple times. for this method, we just need translate every letter one time.
 *
 */

public class RepeatedDNASequences {

	public static void main(String[] args) {
		String s = "AAAAAAAAAAA";
		List<String> list = findRepeatedDnaSequences(s);
		System.out.println(list.iterator().next());
	}
	
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 11) {//this is 11 not 10
        	return list;
        }
        
        int hashcode = 0;
        
        for (int i = 0; i < 10; i++) {
        	/* 'A' - 'A' + 1 = 1  = 1 (mod 5)
    		 * 'C' - 'A' + 1 = 3  = 3 (mod 5)
    		 * 'G' - 'A' + 1 = 7  = 2 (mod 5)
    		 * 'T' - 'A' + 1 = 20 = 0 (mod 5)
    		 * */
        	hashcode = (hashcode << 2) | ((s.charAt(i) - 'A' + 1) % 5);
        }
        System.out.println(hashcode);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(hashcode, 0);
        
        for (int i = 1; i < s.length() - 9; i++) {
        	hashcode = ((hashcode<<2) & ((1<<20) - 1)) | ((s.charAt(i+9) - 'A' + 1) % 5);//fuck, do not forget the parentheses between 1<<20!!!if not, this will mean 1<<19
        	if (map.containsKey(hashcode)) {
        		if (map.get(hashcode) == 0) {// at the beginning, I did not write this if statement. there will be duplicate string in list
        			list.add(s.substring(i, i+10));
        			map.put(hashcode, 1);
        		}
        	} else {
        		map.put(hashcode, 0);
        	}
        }
        return list;
    }
}
