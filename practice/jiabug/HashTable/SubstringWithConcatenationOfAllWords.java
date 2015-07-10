package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * 
 * @author kajia
 *
 * #MinimumWindowSubstring
 * #LongestSubstringWithouRepeatinCharacters
 */


public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println("i:" + i);
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					break;//break the inner loop
				}
				System.out.println("j:" + j);
			}
		}
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}).size());

	}
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordLen = words[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String str : words) {
        	if (map.containsKey(str)) {
        		map.put(str, map.get(str)+1);
        	} else {
        		map.put(str, 1);
        	}
        }

        for (int i = 0; i < s.length()-wordLen*words.length+1; i++) {//do not forget add one !!!
        	int walker = i;
            int count = 0;
        	for (int runner = i; runner < s.length()-wordLen+1; runner += wordLen){//do not forget add one !!!!
        		String str = s.substring(runner, runner+wordLen);
        		if (map.containsKey(str)) {
        			map.put(str, map.get(str)-1);
        			if (map.get(str) < 0) {
        				while (walker <= runner) {
        					String temp  = s.substring(walker, walker+wordLen);
        					map.put(temp, map.get(temp)+1);
        					walker += wordLen;
        				}
        				break;
        			} else {
        				count++;
        			}
        			if (count == words.length) {
        				res.add(walker);
        				while (walker <= runner) {
        					String temp  = s.substring(walker, walker+wordLen);
        					map.put(temp, map.get(temp)+1);
        					walker += wordLen;
        				}
        				break;
        			}
        		} else {
        			while (walker < runner) {
    					String temp  = s.substring(walker, walker+wordLen);
    					map.put(temp, map.get(temp)+1);
    					walker += wordLen;
    				}
        			break;
        		}
        	}
        }
        return res;
    }
    
    public static List<Integer> findSubstring_ganker(String s, String[] words) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	if (s == null || s.length() == 0 || words == null || words.length == 0) {
    		return res;
    	}
    	
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	for (String i: words) {
    		if (map.containsKey(i)) {
    			map.put(i, map.get(i)+1);
    		} else {
    			map.put(i, 1);
    		}
    	}
    	
    	int wordLen = words[0].length();
    	
    	for (int i = 0; i < wordLen; i++) {
    		HashMap<String, Integer> curmap = new HashMap<String, Integer>();
    		int walker = i;
    		int count = 0;
    		for (int runner = i; runner < s.length()-wordLen; runner++) {
    			String str = s.substring(runner, runner+wordLen);
    			if (map.containsKey(str)) {
    				if (curmap.containsKey(str)) {
    					curmap.put(str, curmap.get(str)+1);
    				} else {
    					curmap.put(str, 1);
    				}
    				if (curmap.get(str) <= map.get(str)) {
    					count++;
    				} else {
    					while (curmap.get(str) > map.get(str) ){
    						String temp = s.substring(walker, walker+wordLen);
    						curmap.put(str, curmap.get(str)-1);
    						walker += wordLen;
    					}
    				}
    				if (count == words.length) {
    					res.add(walker);
    				}
    			}
    		}
    	}
    }

}
