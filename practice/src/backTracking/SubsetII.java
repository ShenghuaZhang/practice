package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90
 * https://leetcode.com/problems/subsets-ii/
 * 
 * Given a collection of integers that might contain duplicates nums,
 * return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,2], a solution is:
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author yili3
 * 
 * #Subset
 *
 */
public class SubsetII {
	public List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return null;
		Arrays.sort(nums);
		helper(nums, new ArrayList<Integer>(), list, 0);
		return list;
	}
	private void helper(int[] nums, List<Integer> current,
			List<List<Integer>> list, int index) {
		list.add(new ArrayList<Integer>(current));
		
		for (int i = index; i < nums.length; i++) {
			if(i==index || nums[i]!=nums[i-1]){ // #CombinationSumII
				current.add(nums[i]);
				helper(nums, current, list, i+1);
				current.remove(current.size() - 1);
			}
		}
	}
}
