package BitManipulation;

import java.util.HashMap;

/**
 * 169
 * https://leetcode.com/problems/majority-element/
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * @author kajia
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int majorityElement(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i:nums) {
    		if (map.containsKey(i)) {
    			int count = map.get(i);
    			map.put(i, count + 1);
    		} else {
    			map.put(i, 1);
    		}
    	}
    	
    	for (int i : nums) {
    		if (map.get(i) > nums.length/2) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static int majorityElement_better(int[] nums) {
    	int count = 0;
    	int previous = nums[0];
    	for (int i:nums) {
    		if (i == previous) {
    			count++;
    		} else if (count > 1) {
    			count--;
    		} else {
    			previous = i;
    		}
    	}
    	return previous;
    }
    
    public static int majorityElement_Bit(int[] nums) {
    	int res = 0;
    	
    	for (int i = 0; i < 32; i++) {
    		int ones = 0;
    		int zeros = 0;
    		for (int n:nums) {
    			if (((n>>i)&1) == 1) {
    				ones++;
    			} else {
    				zeros++;
    			}
    		}
    		
    		if (ones > zeros) {
    			res |= (1<<i);
    		}
    	}
    	return res;
    }
}
