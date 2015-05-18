package stack;
/**
 * 150
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	/*
	 * A more functional way by creating an interface and map each operator
	 * string to an implementation of the Operator interface
	 */
	interface Operator {
		int eval(int x, int y);
	}
	private static final Map<String, Operator> map = new HashMap<String, Operator>() {
		private static final long serialVersionUID = -2101448965718964667L;
		{
			put("+", new Operator() {
				public int eval(int x, int y) {
					return x + y;
				}
			});
			put("-", new Operator() {
				public int eval(int x, int y) {
					return x - y;
				}
			});
			put("*", new Operator() {
				public int eval(int x, int y) {
					return x * y;
				}
			});
		}
	};
	
	public void addNewOperator(String s, Operator op){
		map.put(s, op);
	}
	public int evalRPNII(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		
		for (String token : tokens) {
			if (map.containsKey(token)) {
				int y = stack.pop(), x = stack.pop();
				stack.push(map.get(token).eval(x, y));
			} else
				stack.push(Integer.parseInt(token));
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args){
		EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
		test.addNewOperator("/", new Operator() {
				public int eval(int x, int y) {
					return x / y;
				}});
		String[] token = {"4", "13", "5", "/", "+"};
		System.out.print(test.evalRPNII(token));
	}
}
