package stack;

import java.util.Stack;

/**
 * 150
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *   
 * @author kajia
 * yi's code
 */

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));

	}
	
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
        	return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (String s: tokens) {
        	if (s.equals("+")) {
        		stack.push(stack.pop() + stack.pop());
        	} else if (s.equals("-")) {
        		stack.push(-stack.pop() + stack.pop());
        	} else if (s.equals("*")) {
        		stack.push(stack.pop() * stack.pop());
        	} else if (s.equals("/")) {
        		//stack.push(1/stack.pop() * stack.pop()); if we use this, 5, 13, / will output 0; not 2
        		int x = stack.pop();
        		int y = stack.pop();
        		stack.push(y / x);
        	} else {
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.pop();
    }
}
