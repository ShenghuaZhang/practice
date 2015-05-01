package string;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 5.5 131
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab"
 * Return
 * [	
 * 	["aa","b"],
 * 	["a","a","b"]
 * ]
 * 
 * @author yili3
 * 
 * #PalindromePartitioningII	
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s){
		List<List<String>> ret = new ArrayList<>();
		if(s==null || s.length()==0)	return ret;
		helper(s, getDict(s), 0, new ArrayList<String>(), ret);
		return ret;
	}
	private boolean[][] getDict(String s){	/* #LongestPalindromicSubstring */
		boolean[][] dict = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i)==s.charAt(j) && ((j-i<2)||dict[i+1][j-1]))
					dict[i][j] = true;
			}
		}
		return dict;
	}
	private void helper(String s, boolean[][] dict, int start, List<String> item, List<List<String>> ret){
		if(start==s.length()){	/* #WordBreakII */
			ret.add(new ArrayList<String>(item));
			return;
		}
		for(int i=start; i<s.length(); i++){
			if(dict[start][i]){
				item.add(s.substring(start, i+1));
				helper(s, dict, i+1, item, ret);
				item.remove(item.size()-1);
			}
		}
	}
}
