package BitManipulation;

/**
 * 190
 * https://leetcode.com/problems/reverse-bits/
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 * 
 * @author kajia
 * 
 * #ReverseInteger
 *
 */
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBits(43261597));

	}
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int res = 0;
    	int bits = 32;
    	while (n != 0) {
    		res <<= 1;
    		res |= (n & 1);
    		n >>>= 1;//must do unsigned shift
    		bits--;
    	}
    	return res << bits;
    }
    
    public static int reverseBits_discuss(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!??????
                result <<= 1;
        }
        return result;
    }

}
