package stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		final Map<Character, Character> map = new HashMap<Character, Character>() {
			private static final long serialVersionUID = 1L;
			{
				put('(', ')');
				put('{', '}');
				put('[', ']');
			}
		};
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (map.containsKey(c))
				stack.push(c);
			else if (map.containsValue(c))
				if (stack.empty() || map.get(stack.pop()) != c)
					return false;
		}

		return stack.empty();
	}
}
