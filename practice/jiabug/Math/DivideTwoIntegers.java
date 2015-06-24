package Math;

/**
 * 29
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * 
 * @author jiakangze
 * 
 * #Pow #Sqrt
 * 
 */


public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
        	return Integer.MAX_VALUE;
        }
        boolean signflag = ((dividend ^ divisor)>>>31 == 1);
        int res = 0;
        if (dividend == Integer.MIN_VALUE) {
        	dividend -= Math.abs(divisor);// Integer.MIN_VALUE + Integer.MIN_VALUE = 0
        	if (divisor == -1) {
        		return Integer.MAX_VALUE;
        	}
        	res++;
        }
        if (divisor == Integer.MIN_VALUE) {
        	return res;
        }
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        
        while (divisor <= (dividend >> 1)) {
        	divisor <<= 1;
        	digit++;
        }
        
        while (digit >= 0) {//contain '='
        	if (dividend >= divisor) {
        		res += 1<<digit;
        		dividend -= divisor;
        	}
        	divisor >>= 1;
        	digit--;
        }
        
        return signflag ? -res : res;
    }
}
