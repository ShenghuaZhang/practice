package stack;

/**
 * 32
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 */

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int max = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')    stack.push(i);
            else if(!stack.empty()){
                stack.pop();
                max = stack.empty()?Math.max(max,i-start+1):Math.max(max,i-stack.peek());
            }
            else start = i+1;
        }
        
        return max;
    }
}
