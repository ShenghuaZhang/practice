package HashTable;

import java.util.HashMap;

/**
 * 76
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * @author kajia
 * 
 * #LongestSubstringWithouRepeatinCharacters
 * #SubstringWithConcatenationOfAllWords
 * 
 */


public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}
	
    public static String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
        	return null;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < t.length(); i++) {
        	if (map.containsKey(t.charAt(i))) {
        		map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
        	} else {
        		map.put(t.charAt(i), 1);
        	}
        }
        
        int walker = 0;
        int count = 0;
        int minlen = s.length()+1;
        int minstart = 0;
        
        for (int runner = 0; runner < s.length(); runner++) {
        	if (map.containsKey(s.charAt(runner))) {
        		map.put(s.charAt(runner), map.get(s.charAt(runner)) - 1);
        		if (map.get(s.charAt(runner)) >= 0) {//contain the equal......
        			count++;
        		}
        		while (count == t.length()) {
        			if (runner - walker + 1 < minlen) {//contain the start and end, so we need add 1;
        				minlen = runner - walker + 1;
        				minstart = walker;
        			}
        			if (map.containsKey(s.charAt(walker))){
        				map.put(s.charAt(walker), map.get(s.charAt(walker)) + 1);
        				if (map.get(s.charAt(walker)) > 0) {//do not contain the equal
        					count--;
        				}
        			}
        			walker++;
        		}
        		
        	}
        }
        if (minlen > s.length()) {
        	return "";
        }
        return s.substring(minstart, minstart + minlen);//substring does not contain the second parameter. so we  do not need to minus 1;
        
    }

}
