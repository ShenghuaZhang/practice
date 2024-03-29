package Math;


/**
 * 172
 * 
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * 
 * @author jiakangze
 *
 */

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int trailingZeroes(int n) {
        int res = 0;
        
        while (n/5 > 0) {
        	res += n / 5;
        	n /= 5;
        }
        return res;
    }
}
