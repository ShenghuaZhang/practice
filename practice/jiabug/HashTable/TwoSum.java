package HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * 
 * @author jiakangze
 * 
 * #FourSum    #ThreeSum    #ThreeSumClosest
 */

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int[] twoSum(int[] nums, int target) {
    	if (nums == null || nums.length < 2) {
    		return null;
    	}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(target - nums[i])) {
        		return new int[] {map.get(target - nums[i]) + 1, i + 1};
        	}
        	map.put(nums[i], i);
        }
        return null;
    }
    
    public static int[] twoSum_discuss(int[] nums, int target) {
    	if (nums == null || nums.length < 2) {
    		return null;
    	}
    	
    	Arrays.sort(nums);
    	
    	int l = 0;
    	int r = nums.length - 1;
    	
    	while (l != r) {
    		if (nums[l] + nums[r] == target) {
    			return new int[] {l+1, r+1};
    		} else if (nums[l] + nums[r] < target) {
    			l++;
    		} else {
    			r--;
    		}
    	}
    	return null;
    }

}
