package dynamicProgramming;

import java.util.Set;

/**
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
 * #WordBreakII
 * {@link #wordBreakBetter(String, Set)}
 *
 */
public class WordBreak {
	public static boolean wordBreakRecursive(String s, Set<String> dict) {
		if(s==null)	return true;
        return helper(s, dict, 0);
    }
	private static boolean helper(String s, Set<String> dict, int index){
		if(index==s.length())	return true;
		for(int i=1; i<s.length()-index+1; i++)
			if(dict.contains(s.substring(index, index+i)))
				if(helper(s, dict, index+i)) return true;
		return false;
	}
	
	public static boolean wordBreakBetter(String s, Set<String> dict){
		boolean[] rs = new boolean[s.length()];
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<=i; j++){
				if(j==i && dict.contains(s.substring(0, i+1))){
					rs[i] = true;
					break;
				}
				else if(rs[j] && dict.contains(s.substring(j+1, i+1))){
					rs[i] = true;
					break;
				}
			}
		}
		return rs[s.length()-1];
	}
}
