package BitManipulation;

import java.util.HashMap;

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
		System.out.println(reverseBits_discuss(43261597));
		

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
    	
    	return res << bits;//we right move n at most 32 times. at that time, bits will be 0. then the return statement will be res << 0
    	
    }
    
    public static int reverseBits_discuss(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!??????
            	//this method add the n&1 first, then shift the result. For my code, i shift it first, then i add the n&1
                result <<= 1;
        }
        return result;
    }
    
    //If this function is called many times, how would you optimize it?
    private static final HashMap<Byte, Integer> cache = new HashMap<Byte, Integer>();
    
    public static int reverseBits_optimize(int n) {
    	byte [] bytes = new byte[4];
    	
    	for (int i = 0; i < 4; i++) {
    		bytes[i] = (byte)((n>>>(i*8)) & 0xFF);
    	}
    	
    	int res = 0;
    	
    	for (int i = 0; i < 4; i++) {
    		res += getreverse(bytes[i]);
    		if(i < 3) {
    			res <<= 8;
    		}
    	}
    	return res;
    }
    
    private static int getreverse(byte b) {
    	Integer value = cache.get(b);
    	if (value != null) {//key point, because of this, we can optimize the process
    		return value;
    	}
    	value = 0;
    	
    	for (int i = 0; i < 8; i++) {
    		value += (b&1);
    		b >>>= 1;
    		if (i < 7) {	
    			value <<= 1;
    		}
    	}
    	cache.put(b, value);
    	return value;
    			
    }

}
