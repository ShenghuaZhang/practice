package Math;

import java.util.Stack;

/**
 * 224
 * https://leetcode.com/problems/basic-calculator/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 *  non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * @author jiakangze
 *
 */

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int calculate(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = s.length()-1;
        int res = 0;
        while (i >= 0) {
        	if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-') && s.charAt(i) != '(' && s.charAt(i) != ')') {
        		
        	}
        }
        
    }

}
