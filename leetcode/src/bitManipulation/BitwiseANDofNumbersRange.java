package bitManipulation;
/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author yili3
 *
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitI(int m, int n){
		for(int i=0; i<31; i++)
			if((m>>(30-i))!=(n>>(30-i)))	return (n>>(31-i))<<(31-i);
		return m;
	}
}
