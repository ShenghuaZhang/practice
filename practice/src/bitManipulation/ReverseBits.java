package bitManipulation;
/**
 * 190
 * https://leetcode.com/problems/reverse-bits/
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 * @author carllee1991
 * 
 * #ReverseInteger
 *
 */
public class ReverseBits {
	public static int reverseBits(int n){
		int rs = 0, S = 32;
		while(n!=0){
			rs <<= 1;
			rs |= (n&1);
			n >>>= 1;
			S--;
		}
		return rs <<= S;
	}
	public static void main(String[] args){
		System.out.println(reverseBits(1));
		System.out.println("logical right shift -2: "+(-2>>>1));
		System.out.println("arithmetic right shift -2: "+(-2>>1));
	}
}
