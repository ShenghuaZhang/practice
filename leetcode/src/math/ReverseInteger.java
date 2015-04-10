package math;
/**
 * https://leetcode.com/problems/reverse-integer/
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author carllee1991
 * #ReverseBits
 */
public class ReverseInteger {
	public int reverse(int x){
		int ret=0;
		while(x!=0){
			if(Math.abs(ret)>Integer.MAX_VALUE/10)	return 0;
			ret = ret*10+x%10;
			x /= 10;
		}
		return ret;
	}
}
