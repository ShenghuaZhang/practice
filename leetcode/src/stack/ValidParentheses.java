package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s){
		final Map<Character, Character> map = new HashMap<Character, Character>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -1322714841813554287L;

			{
				put('(', ')');
				put('{', '}');
				put('[', ']');
			}
		};
		
		Stack<Character> stack = new Stack<>();
		
		for(char c: s.toCharArray()){
			if(map.containsKey(c))	stack.push(c);
			else if(map.containsValue(c)){
				if(!stack.empty() && map.get(stack.peek())==c)	stack.pop();
				else return false;
			}
		}
		return stack.empty();
	}
}
