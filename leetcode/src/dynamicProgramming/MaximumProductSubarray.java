package dynamicProgramming;
/**
 * 152
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author yili3
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums){
		if(nums==null || nums.length==0)	return 0;
		int global = nums[0], localMax = nums[0], localMin = nums[0];
		for(int i=1; i<nums.length; i++){
			int temp = localMin;
			localMin = Math.min(Math.min(nums[i], localMin*nums[i]), nums[i]*localMax);
			localMax = Math.max(Math.max(nums[i], localMax*nums[i]), nums[i]*temp);
			
			global = Math.max(global, localMax);
		}
		return global;
	}
}
