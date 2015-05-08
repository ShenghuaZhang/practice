package dynamicProgramming;

import java.util.Set;

/**
 * 139
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
 *
 */
public class WordBreak {
	/* DP algorithm */
	public boolean wordBreakBetter(String s, Set<String> wordDict){
		boolean[] inDict = new boolean[s.length()+1];
        inDict[0] = true;
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<=i; j++){
                if(wordDict.contains(s.substring(j, i+1)) && inDict[j]){
                    inDict[i+1] = true;
                    break;
                }
            }
        }
        return inDict[s.length()];
	}
	
	/* Recursive: Time Limit Exceeded */
	public boolean wordBreakRecursive(String s, Set<String> wordDict) {
		if(s==null)	return true;
        return helper(s, wordDict, 0);
    }
	private boolean helper(String s, Set<String> wordDict, int index){
		if(index==s.length())	return true;
		for(int i=index+1; i<=s.length(); i++)
			if(wordDict.contains(s.substring(index, i)))
				if(helper(s, wordDict, i)) return true;
		return false;
	}
	
}
