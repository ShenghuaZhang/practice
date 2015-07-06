package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
 */

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        res.add(item);
        if (nums == null || nums.length < 4) {
        	return res;
        }
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l-3; i++) {
        	for (int j = i+1; j < l-2; j++) {
        		for (int k = j+1; k < l-1; k++) {
        			for (int m = k+1; m < l; m++) {
        				List<Integer> list = new ArrayList<Integer>();
        				if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
        					list.add(nums[i]);
        					list.add(nums[j]);
        					list.add(nums[k]);
        					list.add(nums[m]);
        				}
        				if (!res.contains(list)) {
        					res.add(list);
        				}
        			}
        		}
        	}
        }
        return res;
    }

}
