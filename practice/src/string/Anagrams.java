package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * 49
 * https://leetcode.com/problems/anagrams/
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 */
public class Anagrams {
	public List<String> anagrams(String[] strs){
		List<String> list = new ArrayList<>();
		if(strs==null || strs.length==0) return list;
		
		Map<String, List<String>> map = new HashMap<>();
		for(String s:strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String str = new String(c);
			if(map.containsKey(str))	map.get(str).add(s);
			else{
				List<String> temp = new ArrayList<>();
				temp.add(s);
				map.put(str, temp);
			}
			
		}
		// TODO HashMap iterator
		Iterator<List<String>> itr = map.values().iterator();
		while(itr.hasNext()){
			List<String> temp = (List<String>)itr.next();
			if(temp.size()>1)	list.addAll(temp);
		}
		
		return list;
	}
}
