package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Given n pairs of parentheses, write a function to generate
 * all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n){
		List<String> list = new ArrayList<>();
		int open=0, close=0;
		helper(n, open, close, "", list);
		return list;
	}
	private void helper(int n, int open, int close, String current, List<String> list){
		if(open==n && close==n)	list.add(current);
		else {
			if(n>open)	helper(n, open+1, close, current+"(", list);
			if(open>close)	helper(n, open, close+1, current+")", list);
		}
	}
}
