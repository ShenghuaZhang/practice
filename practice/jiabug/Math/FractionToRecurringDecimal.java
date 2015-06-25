package Math;
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

	}
	//we can use / !!!!
    public static String fractionToDecimal(int numerator, int denominator) {
    	StringBuilder res = new StringBuilder();
    	if (denominator == 0) {
    		return new StringBuilder(Integer.MAX_VALUE).toString();
    	}
    	if (numerator == Integer.MIN_VALUE && denominator == -1) {
    		
    	}
    	if (denominator == Integer.MIN_VALUE) {//we will abs it
    		
    	}
    	char sign = ((numerator ^ denominator) >>> 31 == 1) ? '-':' ';
    	long n = Math.abs(numerator);
    	long d = Math.abs(denominator);
    	res.append(sign);
    	res.append(n/d);
    	
        
    }
}
