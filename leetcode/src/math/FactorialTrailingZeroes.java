package math;
/**
 * 172
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * @author yili3
 *
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n){
		int zeroes = 0;
		while(n/5!=0){
			zeroes += n/5;
			n /= 5;
		}
		return zeroes;
	}
}
