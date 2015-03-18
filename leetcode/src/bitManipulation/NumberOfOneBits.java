package bitManipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * Answer: 
 * http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * 
 * Reference: 
 * http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
 * Improve: http://graphics.stanford.edu/~seander/bithacks.html#CountBitsSetTable
 * 
 * Write a function that takes an unsigned integer
 * and returns the number of ’1' bits it has (also known as
 * the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author yili3
 *
 */

public class NumberOfOneBits {
	// Brian Kernighan’s Algorithm O(logn)
	public static int hammingWeight(int n) {
		int total_ones = 0;
		while (n != 0) {
			n = unsetRightmostOne(n);
			total_ones++;
		}
		return total_ones;
	}
	// simple method of this question (Theta of logn)
	public int hammingWeightII(int n){
		int total_ones = 0;
		while(n!=0){
			total_ones += n & 1;
			n >>= 1;
		}
		return total_ones;
	}
	
	/*	Bit Hack #1. Check if the integer is even or odd.	*/
	public static boolean evenOrNot(int n){
		return (n&1)==0;
	}
	
	/*	Bit Hack #2. Test if the n-th bit is set.	*/
	public static boolean isSetNth(int n, int x){
		return (n & (1<<x))!=0;
	}
	
	/*	Bit Hack #3. Set the n-th bit.	*/
	public static int setNthBit(int n, int x){
		return n | (1<<x);
	}
	
	/*	Bit Hack #4. Unset the n-th bit.	*/
	public static int unsetNthBit(int n, int x){
		return n & ~(1<<x);
	}
	
	/*	Bit Hack #5. Toggle the n-th bit.	*/
	public static int toggleNthBit(int n, int x){
		return n ^ (1<<x);
	}
	
	/*	Bit Hack #6. Unset the rightmost 1-bit.	*/
	public static int unsetRightmostOne(int n){
		return n & (n-1);
	}
	
	/*	Bit Hack #7. Isolate the rightmost 1-bit.	*/
	public static int isolateRightmostOne(int n){
		return n & -n;
	}
	
	/*	Bit Hack #8. Right propagate the rightmost 1-bit.	*/
	// All the 0-bits right to the rightmost 1-bit got turned into ones.
	public static int rightPropagate(int n){
		return n | (n-1);
	}
	
	/*	Bit Hack #9. Isolate the rightmost 0-bit.	*/
	public static int isolateRightmostZero(int n){
		return ~n & (n+1);
	}
	
	/*	Bit Hack #10. Turn on the rightmost 0-bit.	*/
	public static int setRightmostZero(int n){
		return n | (n+1);
	}
}
