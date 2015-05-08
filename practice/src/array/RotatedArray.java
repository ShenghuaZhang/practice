package array;

/**
 * 189
 * https://leetcode.com/problems/rotate-array/
 * 
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3,
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note & Hint:
 * Try to come up as many solutions as you can,
 * there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * #ReverseWordsInAString
 */

import java.util.Arrays;

public class RotatedArray {
	public void rotateI(int[] nums, int k) {
		k %= nums.length;
		int[] temp = new int[nums.length];	// extra space O(n)

		for (int i = 0; i < nums.length; i++)
			temp[i] = nums[(nums.length - k + i) % nums.length];
		for (int i = 0; i < nums.length; i++)
			nums[i] = temp[i];
	}
	
	public static void rotateII(int[] nums, int k){
		k %= nums.length;	// in-place
		reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
	}
	protected static void reverse(int[] nums, int start, int end){
	    for(;start<end;start++, end--){ 
	    	int temp = nums[start];
	    	nums[start] = nums[end];
	    	nums[end] = temp;
	    }
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7};
		rotateII(nums, 4);
		System.out.println(Arrays.toString(nums));
	}
}
