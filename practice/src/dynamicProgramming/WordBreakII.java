package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 140
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * 
 * @author carllee1991
 * 
 * #WordBreak
 *
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict){
		List<String> list = new ArrayList<>();
		if(s==null || wordDict==null) return list;
        boolean[] rs = new boolean[s.length()];
        
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if ((j == i && wordDict.contains(s.substring(0, i + 1)))
						|| (rs[j] && wordDict.contains(s.subSequence(j + 1, i + 1)))) {
					rs[i] = true;
					break;
				}
			}
		}
		if (rs[s.length() - 1]) {
			helper(s, wordDict, 0, "", list);
			return list;
		} else	return list;
	}
	private void helper(String s, Set<String> wordDict, int index, String current, List<String> list){
		if(index==s.length()){
			list.add(current);
			return;
		}
		for(int i=index; i<s.length(); i++){
			if(wordDict.contains(s.substring(index, i+1))){
				StringBuilder sb = new StringBuilder();
				if(current.length()>0){
					sb.append(current);
					sb.append(" "+s.substring(index, i+1));	
				}else sb.append(s.substring(index, i+1));
				helper(s, wordDict, i+1, sb.toString(), list);
			}
		}
	}
}
