package math;

import java.util.HashMap;
import java.util.Map;

/**
 * 166
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * 
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @author yili3
 *
 */
public class FractionToRecuringDecimal {
	 public static String fractionToDecimal(int numerator, int denominator) {
		 StringBuilder sb = new StringBuilder();
		 String sign = (numerator<0==denominator<0 || numerator==0)?"":"-";
		 long num = Math.abs((long)numerator);
		 long den = Math.abs((long)denominator);
		 sb.append(sign);
		 sb.append(num/den);
		 
		 long remainder = num%den;
		 if(remainder==0)	return sb.toString();
		 sb.append(".");
		 Map<Long, Integer> map = new HashMap<>();
		 while(!map.containsKey(remainder)){
			 map.put(remainder,  sb.length());
			 sb.append(10*remainder/den);
			 remainder = 10 * remainder % den;
		 }
		 int index = map.get(remainder);
		 sb.insert(index, "(");
		 sb.append(")");
		 return sb.toString().replace("(0)", "");
	  }
	 public static void main(String[] args){
		 int numerator = 5, denominator = 6;
		 System.out.print(fractionToDecimal(numerator, denominator));
	 }
}
