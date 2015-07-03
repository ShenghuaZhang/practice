package BitManipulation;

/**
 * 201
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author jiakangze
 *
 */

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(1,1));
	}
	
	public static int rangeBitwiseAnd_discuss(int m, int n) {
		int digits = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			digits <<= 1;
		}
		return m * digits;//n is also ok.
	}
	public static int rangeBitwiseAnd(int m, int n) {
		for (int i = 30; i >= 0; i--) {
			if ((m>>i) != (n>>i)) {
				return (m >> (i+1)) << (i+1);//n and m are both ok. 
				//we should get the bit which is next left bit of the different bit. so they both should move i+1
			}
		}
		return m;
	}
	
	
	
	//stupid method
    public static int rangeBitwiseAnd_bad(int m, int n) {
        int res = m;
        for (int i = m+1; i <= n; i++){
        	res &= i;
        }
        return res;
    }
}
