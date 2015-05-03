package np;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 5.3 DP permutations
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * @author yili3
 * 
 * #Permutations
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		if(nums==null || nums.length==0)	return list;
		Arrays.sort(nums);
		
		helper(nums, list, new ArrayList<Integer>(), 0);
		return list;
	}
	private void helper(int[] nums, List<List<Integer>> list, List<Integer> current, int index){
		if(current.size()==nums.length){
			list.add(current);
			return;
		}
		
		for(int i=index; i<nums.length; i++){
			if(i==index || nums[i]!=nums[i-1]){
				current.add(nums[i]);
				helper(nums, list, current, i+1);
				current.remove(current.size()-1);
			}
		}
	}
}
