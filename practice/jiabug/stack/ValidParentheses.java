package stack;

import java.util.Stack;

/**
 * 20
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author kajia
 *
 */

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("(){}[(])"));

	}
	
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (ch == '(' || ch == '{' || ch == '[') {
        		stack.push(ch);
        	} else {
        		if (stack.empty()) {
        			return false;
        		} else if (ch == ')' && stack.pop() != '(') {
        			return false;
        		} else if (ch == '}' && stack.pop() != '{') {
        			return false;
        		} else if (ch == ']' && stack.pop() != '[') {
        			return false;
        		} else {
        			continue;
        		}
        	}
        }
        return stack.empty();
    }
}
