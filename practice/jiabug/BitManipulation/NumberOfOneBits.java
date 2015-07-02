package BitManipulation;

/**
 * 191
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * 
 * Reference:
 * http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
 * http://graphics.stanford.edu/~seander/bithacks.html#CountBitsSetTable
 * 
 * -x is same with ~x + 1
 * 
 * @author jiakangze
 *
 */

public class NumberOfOneBits {

	public static void main(String[] args) {

		System.out.println(hammingWeight(-1));
	}
	
	//Low Level Bit Hacks You Absolutely Must Know:reference
	
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	int count = 0;
        for (int i = n; i != 0; i = (i & (i-1))) {//we should use i != 0, not i > 0 because of unsigned value.!!!!!
            count++;
        }
        return count;
    }

}
