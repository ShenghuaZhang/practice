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
 * the result of original question will not overflow
 *
 */


public class Pow {

	public static void main(String[] args) {
		System.out.println(myPow(-1.00000, -2147483648));
		System.out.println(myPow_recursion(-2,3));
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
    	n = Math.abs(n);//before n%2
    	
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
    
    public static double myPow_recursion(double x, int n) {
    	if (n == 0) {
    		return 1.0;
    	}
    	//think about the process
    	double half = myPow_recursion(x, n/2);
    	if (n % 2 == 0) {
    		return half * half;
    	} else if (n > 0) {
    		return half * half * x;
    	} else {
    		return half * half / x;
    	}
    }
    public static double myPow_recursionWithedge(double x, int n) {
    	if (n == 0) {
    		return 1.0;
    	}
    	double half = myPow_recursionWithedge(x, n/2);
    	if (n % 2 == 0) {
    		if (Math.abs(half) > Double.MAX_VALUE/Math.abs(half)) {
    			return Double.MAX_VALUE;
    		}
    		return half * half;
    	} else if (n > 0) {
    		if (Math.abs(half) > Double.MAX_VALUE/(Math.abs(half)*Math.abs(x))) {
    			return Double.MAX_VALUE;
    		}
    		return half * half * x;
    	} else {
    		if (Math.abs(half) > Double.MAX_VALUE/Math.abs(half)*Math.abs(x)) {
    			return Double.MAX_VALUE;
    		}
    		return half * half / x;//every time, the result divides x, so it will not overflow
    	}
    }

}
