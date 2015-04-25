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
        for(int i=30; i>=0; i--)
            if(m>>i != n>>i) return (m>>(i+1))<<(i+1);
        return m;
    }
}
