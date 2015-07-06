package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * 
 *  For example, given array S = {-1 0 1 2 -1 -4},
 *  A solution set is:
 *  (-1, 0, 1)    (-1, -1, 2)
 *  
 *  
 * @author jiakangze
 *
 * #TwoSum #FourSum
 */

public class ThreeSum {

	public static void main(String[] args) {
		
		int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		List<List<Integer>> res = threeSum(nums); 
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
        if (nums == null || nums.length < 3) {
        	return res;
        }
        
        Arrays.sort(nums);
        
        for (int i = nums.length-1; i >= 2; i--) {
        	
        	if (i < nums.length - 1 && nums[i] == nums[i+1]  ) {// we should judge the nums[i] == nums[i+1] later. this may out of bound
        		//we do not use nums[i-1]. when input is {-2,0,1,1,2}, this will ignore 4th number and also ignore the result [-2,1,1]
        		//we should judge this number first, then check the duplicate number.
        		continue;
        	}
        	List<List<Integer>> item = twoSum(nums, i-1, -nums[i]);
        	
        	for (int j = 0; j < item.size(); j++) {
        		item.get(j).add(nums[i]);
        	}
        	res.addAll(item);
        }
        
        return res;
    }
    
    private static List<List<Integer>> twoSum(int[] nums, int end, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	int l = 0;
    	int r = end;
    	
    	while (l < r) {
    		if (nums[l] + nums[r] == target) {
    			List<Integer> list = new ArrayList<Integer>();
    			
    			list.add(nums[l]);
    			list.add(nums[r]);
    			
    			res.add(list);
    			
    			l++;
    			r--;
    			
    			while (l < r && nums[r] == nums[r+1]) {//this is add 1 not minus 1.
    				//we should judge this number first, then we compare next number with this one. if not, we will ignore this number.
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
