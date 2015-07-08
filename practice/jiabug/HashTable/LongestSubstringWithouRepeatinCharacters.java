package HashTable;

import java.util.HashSet;

/**
 * 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * For example,
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author kajia
 *
 */


public class LongestSubstringWithouRepeatinCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbbbbb"));
	}
	
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
        	return res;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
        	set.add(s.charAt(i));
        	int length = 1;
        	int j = i + 1;
        	for (; j < s.length(); j++) {
        		if (set.add(s.charAt(j))) {
        			length++;
        		}
        	}
        	int k = i;
        	while (s.charAt(k) != s.charAt(j)) {
        		set.remove(s.charAt(k));
        		k++;
        	}
        	i = k;
        	if (length > res) {
        		res= length;
        	}
        }
        return res;
    }

}
