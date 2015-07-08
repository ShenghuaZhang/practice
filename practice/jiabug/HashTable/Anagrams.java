package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 49
 * https://leetcode.com/problems/anagrams/
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * @author kajia
 *
 */

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

	}
    public static List<String> anagrams(String[] strs) {
      /*HashMap<String, String> map = new HashMap<String, String>();
        List<String> res = new ArrayList<String>();
        for (String s:strs) {
        	char[] ch = s.toCharArray();
        	Arrays.sort(ch);
        	String str = new String(ch);
        	if (map.containsKey(str)) {
        		res.add(s);
        	}
        	map.put(str, s);
        }*/ 
        // using this method, we can not record the first string.
    	List<String> res = new ArrayList<String>();
    	if (strs == null || strs.length == 1) {
    		return res;
    	}
    	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	for (String s : strs) {
    		char[] ch = s.toCharArray();
    		Arrays.sort(ch);
    		String str = new String(ch);
    		if (map.containsKey(str)) {
    			map.get(str).add(s);
    		} else {
    			List<String> list = new ArrayList<String>();
    			list.add(s);
    			map.put(str,list);
    		}
    	}
    	
    	Iterator<List<String>> iter = map.values().iterator();
    	while (iter.hasNext()) {
    		List<String> item = (List<String>) iter.next();
    		if (item.size() > 1) {
    			res.addAll(item);
    		}
    	}
    	return res;
    	
    }

}
