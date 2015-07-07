package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18
 * https://leetcode.com/problems/4sum/
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)    (-2, -1, 1, 2)    (-2,  0, 0, 2)
 * 
 * @author jiakangze
 * 
 * #TwoSum  #ThreeSum
 */

public class FourSum {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,5,0,1,5,5,-4};
		List<List<Integer>> res = fourSum(nums, 11); 
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
        	return res;
        }
        Arrays.sort(nums);
        
        for (int i = nums.length-1; i >= 3; i--) {
        	
        	if (i < nums.length - 1 && nums[i] == nums[i+1]) {
        		continue;
        	}
        	
        	List<List<Integer>> threesum = ThreeSum(nums, i-1, target - nums[i]);
        	
        	for (int j = 0; j < threesum.size(); j++) {
        		threesum.get(j).add(nums[i]);
        	}
        	
        	res.addAll(threesum);
        }
        
        return res;
    }
    
    private static List<List<Integer>> ThreeSum(int[] nums, int end, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	for (int i = end; i >= 2; i--) {
    		
    		if (i < end && nums[i] == nums[i+1]) {
    			continue;
    		}
    		
    		List<List<Integer>> twosum = TwoSum(nums, i-1, target - nums[i]);
    		
    		for (int j = 0; j < twosum.size(); j++) {
    			twosum.get(j).add(nums[i]);
    		}
    		
    		res.addAll(twosum);
    	}
    	return res;
    }
    
    private static List<List<Integer>> TwoSum(int[] nums, int end, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	int l = 0;
    	int r = end;
    	
    	while (l < r) {
    		if (nums[l] + nums[r] == target) {
    			List<Integer> item = new ArrayList<Integer>();
    			item.add(nums[l]);
    			item.add(nums[r]);
    			res.add(item);
    			
    			l++;
    			r--;
    			
    			while (l < r && nums[r] == nums[r+1]) {
    				r--;
    			}
    			while (l < r && nums[l] == nums[l-1]) {
    				l++;
    			}
    		} else if (nums[l] + nums[r] > target) {
    			r--;
    		} else {
    			l++;
    		}
    	}
    	return res;
    }

}
