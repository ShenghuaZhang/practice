package array;

/**
 * 209
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a sub-array of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the sub-array [4,3] has
 * the minimal length under the problem constraint.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 * 
 * 
 * @author carllee1991
 *
 */
public class MinimumSizeSubarraySum {
	/* This algorithm is pretty much like the algorithm use in #MaximumRangeNumber*/
	public int minSubArrayLen(int s, int[] nums){
		int length = -1, current = 0, left=0, right=0;
		while(right<nums.length){
			current+=nums[right];
			while(current>=s){
				if(left>right)	return 1;
				if(length>0)	length = Math.min(length, right-left+1);
				else length = right-left+1;
				current-=nums[left];
				left++;
			}
			if(current<s)	right++;
		}
		if(current<s && length==-1)	return 0;
		return length;
	}
}
