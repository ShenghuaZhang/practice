package math;
/**
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * Divide two integers without using multiplication,
 * division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * @author yili3
 *
 */
public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor){
		if(divisor==0)	return Integer.MAX_VALUE;
		// 0. different between >> and >>>
		boolean isNeg = (dividend^divisor)>>>31 == 1;
		int res = 0;
		
		if(dividend == Integer.MIN_VALUE){
			if(divisor==-1)	return Integer.MAX_VALUE;
			// 1. if we do need do this here, it will turns on
			// Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE;
			dividend += Math.abs(divisor);
			res++;
		}
		
		if(divisor == Integer.MIN_VALUE)	return res;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while(divisor <= dividend >> 1){
			divisor <<= 1;
			digit++;
		}
		
		while(digit>= 0){
			if(dividend >= divisor){
				res += 1<< digit;
				dividend -= divisor;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg?-res:res;
	}
	
	public static void main(String[] args){
		// 0. different between >> and >>>
		System.out.print((short) 0b1000000000000000>>>31);
		System.out.print(" ");
		System.out.println((short) 0b1000000000000000>>31);
		// 1. Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE;
		System.out.print(Math.abs(Integer.MIN_VALUE) + " ");
		System.out.println(Integer.MIN_VALUE + Math.abs(Integer.MIN_VALUE));
	}
}
