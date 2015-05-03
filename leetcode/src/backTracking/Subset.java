package backTracking;
/**
 * 78
 * https://leetcode.com/problems/subsets/
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsetsRecursive(int[] nums) {
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
			current.add(nums[i]);
			helper(nums, current, list, i+1);
			current.remove(current.size() - 1);
		}
	}
	
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());

		Arrays.sort(S);
		for (int i : S) {
			List<List<Integer>> tmp = new ArrayList<>();
			for (List<Integer> sub : res) {
				List<Integer> a = new ArrayList<>(sub);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
		}
		return res;
	}
}
