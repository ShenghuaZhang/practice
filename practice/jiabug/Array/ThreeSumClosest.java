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

		int[] nums = new int[]{89,-17,-41,9,56,-8,40,38,98,-31,80,-1,-40,-73,28,55,15,89,-83,87,-42,-22,61,64,-94,-33,-38,25,-20,-80,37,99,-72,74,16,-25,-21,-73,-73,-72,65,-4,-72,46,60,7,-25,-14,-58,-50,14,-99,88,50,75,-59,94,-74,25,23,-10,-47,-1,-30,81,-66,54,-64,-1,68,-1,47,55,-59,5,64,45,83,-3,-38,-59,46,33,54,55,9,-13,50,-43,-48,57,97,-55,-13,-25,-9,-20,63,30,88,-4,74,19,-87,-32};
		int res = threeSumClosest(nums, -297); 
	    System.out.println(res);
	}
    public static int threeSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length < 3) {
    		return -1;
    	}
    	int res = nums[0] + nums[1] + nums[2] - target;
        Arrays.sort(nums);

        for (int i = nums.length-1; i >= 2; i--) {//here, we should include 2!!! the first three are not 89,-17,-41. do not forget sort.
        	if (i < nums.length-1 && nums[i] == nums[i+1]) {
        		continue;
        	}
        	
        	int gap = twoSumGap(nums, i-1, nums[i] - target);
        	if (Math.abs(gap) < Math.abs(res)) {
        		res = gap;
        	}
        }
        return res + target;
    }
    
    private static int twoSumGap(int[] nums, int end, int target) {
    	int res = target + nums[end] + nums[end-1];
    	
    	int l = 0;
    	int r = end;
    	
    	while (l < r) {
    		int gap = target + nums[l] + nums[r];
    		if (gap == 0) {
    			return gap;
    		}
    		if (Math.abs(gap) < Math.abs(res)) {
    			res = gap;
    		}
    		if (gap > 0){
    			r--;
    		} else {
    			l++;
    		}
    	}
    	return res;
    }

}
