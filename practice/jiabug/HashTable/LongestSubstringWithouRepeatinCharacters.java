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
 * #MinimumWindowSubstring
 * #SubstringWithConcatenationOfAllWords
 *
 */


public class LongestSubstringWithouRepeatinCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbtatlud"));
	}
	
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
        	return res;
        }
        int runner = 0;
        int walker = 0;
        HashSet<Character> set = new HashSet<Character>();
        
        while (runner < s.length()) {
        	if (set.contains(s.charAt(runner))){
        		if (runner - walker > res) {
        			res = runner - walker;
        		}
        		while (walker < s.length() && s.charAt(walker) != s.charAt(runner)) {//there is no need to write walker < s.length().
        			set.remove(s.charAt(walker));
        			walker++;
        		}
        		walker++;
        	} else {
        		set.add(s.charAt(runner));
        	}
        	runner++;
        }
        return Math.max(res, runner - walker);
    }

}
