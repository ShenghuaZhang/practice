package Math;

/**
 * 69
 * https://leetcode.com/problems/sqrtx/
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * 
 * @author jiakangze
 * 
 * binary search
 * 
 * #DivideTwoIntegers #Pow
 */


public class Sqrt {

	public static void main(String[] args) {
//		for (int i = 4; i < 240; i ++) {
//			System.out.println(mySqrt(i));
//		}
		System.out.println(mySqrt(35));
		//System.out.println(sqrt(25));
	}
    public static int mySqrt(int x) {
    	if (x <= 0) {
    		return 0;
    	}
    	int l = 1;
    	int r = x / 2 + 1;//we can remove the 1
    	
    	while (l <= r) {
    		int m = (l + r) / 2 + 1; //if we add 1 at here. when the input is 1, 2, 3, it will dead loop
    		//when l == r, m should equals l or r. but if we add 1 to m, it will not end
    		//if l = r is the result, we should return l or r. if we add 1 it will not end loop
    		if (x / m >= m && x / (m+1) < (m+1)) {
    			//we do not use x >= m * m, If (m * m) overflows the 32 bit int limit, you might end up with an infinite loop.
    			return m;
    		}
    		if (x / m < m) {
    			r = m - 1;
    		} else {
    			l = m + 1;
    		}
    	}
        return 0; // no matter which value it return.
    }
    
    public static double sqrt(int x) {
		if(x<=0)	return 0;
		double i = 0, j = 1;
		while (i != j) {
			i = j;
			
			j = (j + x / j) / 2;//think about this process. decrease the gap between 1 and x/2
			//System.out.println(i);
			//System.out.println(j);
		}
		return i;
	}

}
