package array;

/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Rotate an array of n elements to the right by k steps.
 */

import java.util.Arrays;

public class RotatedArray {
	/*
	 * Time Limit Exceeded
	 */
	public static void rotateI(int[] nums, int k){
		int length = nums.length;
		if(length<=k)	return;
		for(int i=0; i<k; i++)
			for(int j=length-1; j>0; j--)
				swap(nums, j, j-1);
	}
	/*
	 * Right answer
	 */
	public static void rotateII(int[] nums, int k){
		k %= nums.length;
		reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
	}
	protected static void reverse(int[] nums, int start, int end){
	    for(;start<end;start++, end--) swap(nums, start, end);
	}
	
	protected static void swap(int[] nums, int first, int second){
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7};
		rotateII(nums, 4);
		System.out.println(Arrays.toString(nums));
	}
}
