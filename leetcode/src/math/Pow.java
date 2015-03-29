package math;
/**
 * https://leetcode.com/problems/powx-n/
 * 
 * Implement pow(x, n).
 * 
 * @author yili3
 *
 */
public class Pow {
	static double pow(double x, int n){
		if(n==0)	return 1;
		double half = pow(x, n/2);
		if(n%2==0)	return half*half;
		else if(n>0)	return half*half*x;
		else return half*half/x;
	}
	
	public static void main(String[] args){
		System.out.print(pow(1, Integer.MIN_VALUE));
	}
}
