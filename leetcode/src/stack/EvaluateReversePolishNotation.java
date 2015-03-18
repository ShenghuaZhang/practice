package stack;
/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList(
			"+", "-", "*", "/"));

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = stack.pop(), x = stack.pop();
				stack.push(eval(x, y, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	private int eval(int x, int y, String operator) {
		switch (operator) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		default:
			return x / y;
		}
	}

	/*
	 * A more functional way by creating an interface and map each operator
	 * string to an implementation of the Operator interface
	 */

	interface Operator {
		int eval(int x, int y);
	}
	private static final Map<String, Operator> map = new HashMap<String, Operator>() {
		/** Review about serialVersionUID
		 * The serialization runtime associates with each serializable class a
		 * version number, called a serialVersionUID, which is used during
		 * deserialization to verify that the sender and receiver of a
		 * serialized object have loaded classes for that object that are
		 * compatible with respect to serialization. If the receiver has loaded
		 * a class for the object that has a different serialVersionUID than
		 * that of the corresponding sender's class, then deserialization will
		 * result in an InvalidClassException. A serializable class can declare
		 * its own serialVersionUID explicitly by declaring a field named
		 * "serialVersionUID" that must be static, final, and of type long:
		 */
		private static final long serialVersionUID = 1L;

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
			put("/", new Operator() {
				public int eval(int x, int y) {
					return x / y;
				}
			});
		}
	};

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

}
