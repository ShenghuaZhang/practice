package Array;

import java.util.Arrays;

/**
 * 16
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 *  For example, given array S = {-1 2 1 -4}, and target = 1.
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *  
 * @author jiakangze
 *
 * #TwoSum #ThreeSum #FourSum
 */

public class ThreeSumClosest {

	public static void main(String[] args) {

		int[] nums = new int[]{1,1,-1,-1,3};
		int res = threeSumClosest(nums, 1); 
	    System.out.println(res);
	}
    public static int threeSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length < 3) {
    		return -1;
    	}
    	int[] res = new int[2];
        res[1] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 2; i--) {
        	if (i < nums.length-1 && nums[i] == nums[i+1]) {
        		continue;
        	}
        	
        	int[] gap = twoSumGap(nums, i-1, target - nums[i]);
        	
        	if (gap[1] < res[1]) {
        		res[1] = gap[1];
        		res[0] = gap[0] + nums[i];
        	}
        }
        return res[0];
    }
    
    private static int[] twoSumGap(int[] nums, int end, int target) {
    	int[] res = new int[2];
    	res[1] = Integer.MAX_VALUE;
    	
    	int l = 0;
    	int r = end;
    	
    	while (l < r) {
    		int sum = target - nums[l] - nums[r];
    		if (sum == 0) {
    			res[0] = nums[l] + nums[r];
    			res[1] = 0;
    			return res;
    		}
    		if (Math.abs(sum) < res[1]) {
    			res[0] = nums[l] + nums[r];
    			res[1] = Math.abs(sum);
    		}
    		if (sum > 0){
    			l++;
    		} else {
    			r--;
    		}
    	}
    	return res;
    }

}
