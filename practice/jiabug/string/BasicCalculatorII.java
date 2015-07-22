package string;

import java.util.Stack;

/**
 * 227
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * 
 * @author jiakangze
 *
 */

public class BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int calculate(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
        	return res;
        }
        
        Stack<Integer> stack  = new Stack<Integer>();
        
        int number = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (Character.isDigit(ch)) {
        		number = number * 10 + s.charAt(i) - '0' - 0;
        	}
        	if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
        		if (sign == '+') {
        			stack.push(number);
        		} else if (sign == '-') {
        			stack.push(-number);
        		} else if (sign == '*') {
        			stack.push(stack.pop() * number);
        		} else if (sign == '/') {
        			stack.push(stack.pop() / number);
        		}
        		sign = ch;
        		number = 0;
        	}
        }
        
        while (!stack.isEmpty()) {
        	res += stack.pop();
        }
        return res;
    }

}
