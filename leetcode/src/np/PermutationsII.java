package np;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47
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
	public List<List<Integer>> permuteUniqueMine(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		if(nums==null || nums.length==0)	return list;
		Arrays.sort(nums);
		List<Integer> remain = new ArrayList<>();
		for(int i:nums) remain.add(i);
		helper(nums, list, new ArrayList<Integer>(), remain);
		return list;
	}
	private void helper(int[] nums, List<List<Integer>> list, List<Integer> current, List<Integer> remain){
		if(current.size()==nums.length){
			list.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i=0; i<remain.size(); i++){
			if(i==0 || remain.get(i)!=remain.get(i-1)){
				int temp = remain.get(i);
				current.add(temp);
				remain.remove(i);
				helper(nums, list, current, remain);
				current.remove(current.size()-1);
				remain.add(i, temp);
			}
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length == 0)	return list;
		Arrays.sort(nums);
		
		helper(nums, new boolean[nums.length], new ArrayList<Integer>(), list);
		return list;
	}
	private void helper(int[] nums, boolean[] used, List<Integer> current,
			List<List<Integer>> list) {
		if (current.size() == nums.length) {
			list.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])
				continue;
			if (!used[i]) {
				used[i] = true;
				current.add(nums[i]);
				helper(nums, used, current, list);
				current.remove(current.size() - 1);
				used[i] = false;
			}
		}
	}
	
	
}
