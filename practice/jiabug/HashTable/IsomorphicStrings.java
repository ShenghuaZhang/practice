package HashTable;

import java.util.HashMap;

/**
 * 205
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 * @author kajia
 *
 */

public class IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic_discuss("ab", "aa"));
	}
	
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) {
        	return true;
        }
        
        HashMap <Character, Character> map =new HashMap<Character, Character>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c1 = s.charAt(i);
        	char c2 = t.charAt(i);
        	if (map.containsKey(c1)) {
        		if (map.get(c1).equals(c2)) {
        			return false;
        		}
        	} else {
        		if (map.containsValue(c2)) {
        			return false;
        		} else {
        		    map.put(c1, c2);
        		}
        	}
        }
        return true;
    }
    
    public static boolean isIsomorphic_discuss(String s, String t) {
    	int[] map = new int[512];
    	
    	for (int i= 0; i < s.length(); i++) {
    		char c1 = s.charAt(i);
    		char c2 = t.charAt(i);
    		if (map[c1] != map[c2 + 256]) {
    			return false;
    		} 
    		map[c1] = map[c2 + 256] = i+1;//we should add 1. the default value of array is all zero. so they will be same. for example, "ab" and "aa"
    	}
    	return true;
    }

}
