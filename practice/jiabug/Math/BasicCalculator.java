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
		Stack<Character> stack = new Stack<Character>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(calculate("1-(5)"));
		

	}
    public static int calculate(String s) {
    	if (s.length() == 0 || s == null) {
    		return 0;
    	}
        Stack<Integer> stack = new Stack<Integer>();
        
        int res = 0;
        int sign = 1;
        int number = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		number = number * 10 + (int)(c - '0');//a number may have two digits.
        	} else if (c == '+') {
        		res += sign * number;
        		sign = 1;
        		number = 0;
        	} else if ( c == '-') {
        		res += sign * number;
        		sign = -1;
        		number = 0;
        	} else if (c == '(') {
        		stack.push(res);
        		stack.push(sign);
        		res = 0;//ignore the previous value, reset the old value
        		sign = 1;
        	} else if (c == ')') {
        		res += sign * number;//inside value 
        		res = stack.pop() * res + stack.pop();//add the previous value
        		number = 0;
        	}
        }
        if (number != 0) {
        	res += sign * number;
        }
        return res;
    }

}
