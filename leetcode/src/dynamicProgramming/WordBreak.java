package dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Apr.3 2015
 * https://leetcode.com/problems/word-break/
 * 
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author carllee1991
 *
 */
public class WordBreak {
	public static boolean wordBreak(String s, Set<String> dict) {
		if(s==null || s.length()==0)	return true;
        return helper(s, dict, 0);
    }
	private static boolean helper(String s, Set<String> dict, int index){
		if(index==s.length())	return true;
		
		for(int i=1; i<s.length()-index+1; i++)
			if(dict.contains(s.substring(index, index+i)))
				if(helper(s, dict, index+i)) return true;
		
		return false;
	}
	
	public static void main(String[] args){
		String s = "aaaaa";
		HashSet<String> dict = new HashSet<String>(){
			{add("aa");	add("a");}};
		System.out.println(wordBreak(s, dict));
	}
}
