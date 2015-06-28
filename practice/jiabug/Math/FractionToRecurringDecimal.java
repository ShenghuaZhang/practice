package Math;

import java.util.HashMap;

/**
 * 166
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * 
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 *     Given numerator = 1, denominator = 2, return "0.5".
 *     Given numerator = 2, denominator = 1, return "2".
 *     Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author jiakangze
 *
 */
public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("abc");
		sb.insert(0, "x");//know the offset
		System.out.println(sb);
		
		System.out.println(fractionToDecimal(11, 7));//study the output
		
	}
	//we can use / !!!!
    public static String fractionToDecimal(int numerator, int denominator) {
    	StringBuilder res = new StringBuilder();
    	/*if (denominator == 0) {
    		return new StringBuilder(Integer.MAX_VALUE).toString();
    	}
    	if (numerator == Integer.MIN_VALUE && denominator == -1) {
    		
    	}
    	if (denominator == Integer.MIN_VALUE) {//we will abs it
    		if we use this, we should consider the situation of repeating and unrepeating. this will be complicated.
    	}*/
    	if (numerator == 0) {//if numerator is 0 and denominator is -5, we should get "0" rather than "-0".
    		return new StringBuilder("0").toString();
    	}
    	String sign = ((numerator ^ denominator) >>> 31 == 1) ? "-":"";
    	long n = Math.abs((long)numerator);
    	long d = Math.abs((long)denominator);
    	System.out.println("n/d:" + n/d);
    	res.append(sign);
    	res.append(n/d);
    	long remainder = n % d;
    	if (remainder == 0) {
    		return res.toString();
    	}
    	res.append('.');
    	HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    	while (!map.containsKey(remainder)) {
    		map.put(remainder, res.length());
    		res.append((10 * remainder) / d);
    		remainder = (remainder * 10) % d;
    	}
    	res.insert(map.get(remainder), "(");
    	res.append(")");
    	System.out.println("res: " + res);
//    	return res.toString().replaceAll("(0)", "");
//    	return res.toString().replaceFirst("(0)", ""); the first argument is regex, so we can not get correct answer
    	return res.toString().replace("(0)", "");
      
    }
}
