package math;

import java.util.HashMap;
import java.util.Map;

/**
 * 13
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * Given a ROMAN numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * N: 5000 M: 1000 D: 500 C: 100 L: 50 X: 10 V:5 I:1
 * 
 * @author yili3
 * #IntegerToRoman
 */
public class RomanToInteger {
	private final Map<Character, Integer> map = new HashMap<Character, Integer>(){
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
	
	public int romanToInt(String s){
		int previous = map.get(s.charAt(0));
		int result = map.get(s.charAt(0));
		
		for(int i=1; i<s.length(); i++){
			if(previous<map.get(s.charAt(i)))
				result -= (2*previous);
			
			result += map.get(s.charAt(i));
			previous = map.get(s.charAt(i));
		}
		
		return result;
	}
}
