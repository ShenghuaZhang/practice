package math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Given a ROMAN numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author yili3
 *
 */
public class RomanToInteger {
	// TODO: Know the way to initialize the HashMap #EvaluateReversePolishNotation
	private static final Map<Character, Integer> map = new HashMap<Character, Integer>(){
		private static final long serialVersionUID = 1L;
		{
	        put('I', 1);
	        put('V', 5);
	        put('X', 10);
	        put('L', 50);
	        put('C', 100);
	        put('D', 500);
	        put('M', 1000);
	        put('N', 5000);
		}
	};
	
	public static int romanToInt(String s){
		int previous = map.get(s.charAt(0));
		int result = map.get(s.charAt(0));
		
		for(int i=1; i<s.length(); i++){
			if(previous<map.get(s.charAt(i)))
				result -= (2*previous);
			
			previous= map.get(s.charAt(i));
			result += previous;
		}
		
		return result;
	}
}
