package HashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 219
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k.
 * 
 * @author kajia
 *
 */

public class ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	
    	if (nums == null || nums.length == 0) {
    		return false;
    	}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i])) {
        		if (i - map.get(nums[i]) <= k) {//i - map.get(nums[i]) rather than map.get(nums[i]) - i
        			return true;
        		}
        	} 
        	map.put(nums[i], i);
        }
        return true;
    }
    
    public static boolean containsNearbyDuplicate_discuss(int[] nums, int k) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (i > k) {
    			set.remove(nums[i-k-1]);//nums[i-k] is in the right range. so we should remove the forword one.
    		}
    		if (!set.add(nums[i])) {
    			return true;
    		}
    	}
    	return false;
    }

}
