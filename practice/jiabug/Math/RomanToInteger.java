package Math;

import java.util.HashMap;

/**
 * 13
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * N: 5000 M: 1000 D: 500 C: 100 L: 50 X: 10 V:5 I:1
 * 
 * @author kajia
 * 
 * http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
 *
 */


public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int romanToInt(String s) {
    	int res = 0;
        for (int i = 0; i < s.length(); i++) {
        	switch (s.charAt(i)) {
        	case 'M':
        		res += 1000;
        		break;
        	case 'D':
        		res += 500;
        		break;
        	case 'C':
        		if (i < s.length()-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
        			res -= 100;
        		} else {
        			res += 100;
        		}
        		break;
        	case 'L':
        		res += 50;
        		break;
        	case 'X':
        		if (i < s.length()-1 && (s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L')) {
        			res -= 10;
        		} else {
        			res += 10;
        		}
        		break;
        	case 'V':
        		res += 5;
        		break;
        	case 'I':
        		if (i < s.length()-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
        			res -= 1;
        		} else {
        			res += 1;
        		}
        		break;
        		default:
        			System.out.println("wrong roman number!");
        	}
        	
        }
        return res;
    }
    
  //the left digit only can contain one number which is small than the right digit
    public static int romanToInt_yi(String s) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	map.put('N', 5000);
    	
    	int previous = map.get(s.charAt(0));
    	int result = map.get(s.charAt(0));
    	
    	for (int i = 1; i < s.length(); i++) {
    		if (previous < map.get(s.charAt(i))) {
    			result -= 2 * previous;
    		}
    		previous = map.get(s.charAt(i));
    		result += map.get(s.charAt(i));
    	}
    	return result;
    }

}
