package HashTable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 217
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * 
 * @author kajia
 *
 */


public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i:nums) {
        	if (!set.add(i)) {
        		return true;
        	}
        }
        return false;
    }
    
    public static boolean containDuplicate_discuss(int[] nums) {
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 1; i++) {
    		if(nums[i] == nums[i+1]) {
    			return true;
    		}
    	}
    	return false;
    }

}
