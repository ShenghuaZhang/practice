package Math;

/**
 * 50 
 * https://leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n).
 * 
 * 
 * @author jiakangze
 *
 * http://stackoverflow.com/questions/3884793/minimum-values-and-double-min-value-in-java
 *
 */


public class Pow {

	public static void main(String[] args) {
		System.out.println(myPow(-1.00000, -2147483648));
	}
    public static double myPow(double x, int n) {
    	if (n == 0) {
    		return 1.0;
    	}
    	double res = 1.0;
    	if (n < 0) {
    		if (x >= 1.0 / Double.MAX_VALUE || x <= 1.0 / -Double.MAX_VALUE) {// not &&!!!!!
    			x = 1.0 / x;
    		} else {
    			return Double.MAX_VALUE;
    		}
    		
    		if ( n == Integer.MIN_VALUE) {
    			res *= x;
    			n++;
    		}
    	}
    	n = Math.abs(n);
    	
    	boolean signflag = true;
    	
    	if ((n%2 == 1) && (x < 0)) {
    		signflag = false;
    	}
    	
    	x = Math.abs(x);
    	
    	while (n > 0) {
    		if ((n & 1) == 1) {
    			if (res > Double.MAX_VALUE/x) {
    				return Double.MAX_VALUE;
    			}
    				res *= x;
    		}
    			x *= x;
    			n = (n >> 1); 
    	}
    	return signflag ? res : -res;
    }

}
