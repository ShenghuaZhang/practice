package math;

/**
 * 50
 * https://leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n).
 * 
 * @author yili3
 *
 */
public class Pow {
	static double pow(double x, int n){
		if(n==0)	return 1.0;
		double res = 1.0;
		if(n<0){
			if(x >= 1.0/Double.MAX_VALUE || x <= 1.0/-Double.MAX_VALUE)
				x = 1.0/x;
			else
				return Double.MAX_VALUE;
			if(n == Integer.MIN_VALUE){
				res *= x;
				n++;
			}
		}
		
		n = Math.abs(n);
		boolean isNeg = (n%2==1 && x<0);
		x = Math.abs(x);
		while(n>0){
			if((n&1) == 1){
				if(res > Double.MAX_VALUE/x)	return Double.MAX_VALUE;
				res *= x;
			}
			x *= x;
			n = n >> 1;
		}
		return isNeg?-res:res;
	}
	
	static double powRecursion(double x, int n) {
		if (n == 0)	return 1;
		
		double half = pow(x, n / 2);
		if (n % 2 == 0)	return half * half;
		else if (n > 0)	return half * half * x;
		else	return half * half / x;
	}

	public static void main(String[] args) {
		System.out.print(pow(5, 5));
	}
}
