package math;
/**
 * https://leetcode.com/problems/sqrtx/
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * @author yili3
 *
 */
public class Sqrt {
	public static double sqrt(int x) {
		if(x<=0)	return 0;
		double i = 0, j = 1;
		while (i != j) {
			i = j;
			j = (j + x / j) / 2;
		}
		return i;
	}
	
	public static int sqrtII(int x) {
        if (x <= 0)	return 0;
		
		int left = 1, right = x/2+1, mid = (left+right)/2;
		for (;left <= right; mid = (left+right)/2){
			if (mid<=x/(mid) && mid+1>x/(mid+1)) return mid;
			else if (mid > x/mid)	right = mid-1;
			else	left = mid+1;
		}
		return -1;
	}
}
