package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 30
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author carllee1991
 * 
 * #MinimumWindowSubstring
 * #LongestSubstringWithoutRepeatingCharacters
 * #LongestSubstringWithAtMostTwoDistinctCharacters
 *
 */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		Map<String, Integer> dict = new HashMap<>();
		for(String st:words){
			if(dict.containsKey(st)) dict.put(st, dict.get(st)+1);
			else dict.put(st, 1);
		}
		
		int length=words[0].length(), size=words.length;
		for(int i=0; i<length; i++){
			int right=i, left=i;
			for(int cnt = 0;right<s.length()-length+1; right+=length){
				String temp = s.substring(right, right+length);
				if(dict.containsKey(temp) && dict.get(temp)>0){
					dict.put(temp, dict.get(temp)-1);
					++cnt;
					if(cnt==size){
						list.add(left);
						dict.put(s.substring(left, left+length), dict.get(s.substring(left, left+length))+1);
						--cnt;
						left+=length;
					}
				}
				else if(dict.containsKey(temp)){
					for(;!s.substring(left, left+length).equals(temp); left+=length, --cnt)
						dict.put(s.substring(left, left+length), dict.get(s.substring(left, left+length))+1);
					left+=length;
				}else{
					cnt=0;
					for(; left<right; left+=length)
						dict.put(s.substring(left, left+length), dict.get(s.substring(left, left+length))+1);;
					left = right+length;
				}
			}
			for(; left<right; left+=length)
				dict.put(s.substring(left, left+length), dict.get(s.substring(left, left+length))+1);;
			left = right+length;
		}
		return list;
	}
}
