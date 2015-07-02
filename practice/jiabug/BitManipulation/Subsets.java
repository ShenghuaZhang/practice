package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 78
 * https://leetcode.com/problems/subsets/
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 *     Elements in a subset must be in non-descending order.
 *     The solution set must not contain duplicate subsets.
 *     
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]

 * @author kajia
 *
 */

public class Subsets {

	public static void main(String[] args) {
		
	}
	
    public static List<List<Integer>> subsets_bad(int[] nums) {
    	/*
    	 * if the input is [1,2,3]
    	this method will not contain the [1,3]
    	*/
        List<List<Integer>> res= new ArrayList<>();
        res.add(new ArrayList<Integer>());
    	if (nums == null || nums.length == 0) {
    		return res;
    	}
    	
    	Arrays.sort(nums);
    	
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i; j < nums.length; j++) {
        		List<Integer> oneSet = new ArrayList<Integer>();
        		for (int k = i; k <= j; k++) {
        			oneSet.add(nums[k]);
        		}
        		res.add(oneSet);
        	}
        }
        return res;
    }
    
    public static List<List<Integer>> subsets (int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();// why we do not need write content in the parentheses. reference yi's??????
    	res.add(new ArrayList<Integer>());
    	
    	if (nums == null || nums.length == 0) {
    		return res;
    	}
    	
    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length; i++) {
    		int size = res.size();
    		for (int j = 0; j < size; j++) {
    			List<Integer> item = new ArrayList<>(res.get(j));
    			item.add(nums[i]);
    			res.add(item);
    		}
    	}
    	return res;
    }
    
    
    //////////////recursive method////////////////
    public static List<List<Integer>> subsets_recursive(int[] nums) {
    	
    	if (nums == null) {
    		return null;
    	}
    	
    	Arrays.sort(nums);
    	
    	return helper(nums, nums.length-1);//do not forget to subtract 1
    }
    
    private static List<List<Integer>> helper(int[] nums, int index) {
    	if (index == -1) {//this number is -1 not 0
    		List<List<Integer>> res = new ArrayList<List<Integer>>();
    		res.add(new ArrayList<Integer>());
    		return res;
    	}
    	
    	List<List<Integer>> res = helper(nums, index-1);
    	
    	int size = res.size();
    
    	for (int i = 0; i < size; i++) {
    		List<Integer> item = new ArrayList<Integer>(res.get(i));
    		item.add(nums[index]);//at the beginning, we forgot to write nums....just write the index..
    		res.add(item);
    	}
    	return res;
    	
    }

}
