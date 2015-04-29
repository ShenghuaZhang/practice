package dynamicProgramming;
/**
 * 53
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * @author yili3
 *
 */
public class MaximumSubarray {
	// Dynamic programming
	public int maxSubArrayDP(int[] nums){
		int local=0, global = nums[0];
        for(int n:nums){
            local = Math.max(local+n, n);
            global = Math.max(global, local);
        }
        return global;
	}
	// Divided and Conquer
	public int maxSubArrayDC(int[] nums){
		return helper(nums, 0, nums.length-1);
	}
	private int helper(int[] nums, int start, int end){
	    if(start>end)   return 0;
	    if(start==end)  return nums[start];
		int left = helper(nums, start, (start+end)/2),
				right = helper(nums, (start+end)/2+1, end),
				middle = helper(nums, start, (start+end)/2, end);
		return Math.max(left, Math.max(right, middle));
	}
	private int helper(int[] nums, int start, int middle, int end){
		int leftMax = nums[middle], rightMax =nums[middle+1], point = middle, current = 0;
		while(point>=start){
			current += nums[point--];
			if(leftMax<current)	leftMax = current;
		}
		current = 0; point = middle+1;
		while(point<=end){
			current += nums[point++];
			if(rightMax<current) rightMax = current;
		}
		return leftMax + rightMax;
	}
}
