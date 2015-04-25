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
	public int rangeBitwiseAnd(int m, int n) {
		int move = 0;
		for(int temp=n^m; temp!=0; temp>>=1, move++);
		return m&~((1<<move)-1);
	}
}
