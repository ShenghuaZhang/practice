package array;

/**
 * https://leetcode.com/problems/maximum-gap/
 * 
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * Try to solve it in linear time/space. Return 0
 * if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers
 * and fit in the 32-bit signed integer range.
 * 
 * @author yili3
 *
 */
public class MaximumGap {
	public static int maximumGap(int[] num) {
		if(num.length==1 || num==null || num.length==0)	return 0;
		/* Radix Algorithm	#RadixSort */
		int x = 1, max = num[0], k=0;
		for(int n:num) max = Math.max(max, n);
		int[][] bucket = new int[10][num.length];
		int[] order = new int[10];
		
		while(x <= max){
			for(int n:num){
				int digit = (n / x) % 10;
				bucket[digit][order[digit]] = n;
				order[digit]++;
			}
			for(int i=0; i<10; i++){
				for(int j=0; j<order[i]; j++)
					num[k++] = bucket[i][j];
				order[i] = 0;
			}
			x *= 10;
			k = 0;
		}
		
		max = 0;
		for(int i=1; i<num.length; i++)
			max = Math.max(max, num[i]-num[i-1]);
		
		return max;
	}
	
	public static void main(String[] args){
		System.out.println(maximumGap(new int[]{1, 1000}));
	}
}
