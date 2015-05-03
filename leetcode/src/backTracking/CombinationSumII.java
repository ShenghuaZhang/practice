package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6] 
 * 
 * @author yili3
 *
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> list = new ArrayList<>();
		if(candidates==null || candidates.length==0)	return list;
		Arrays.sort(candidates);
		
		helper(candidates, target, list, 0, new ArrayList<Integer>());
		
		return list;
	}
	private void helper(int[] candidates, int target, List<List<Integer>> list, int index,
			List<Integer> current){
		if(target==0){
			list.add(new ArrayList<Integer>(current));
			return;
		}
		for(int i=index; i<candidates.length; i++){
			if(candidates[i]>target)	break;
			if(i==index || candidates[i]!=candidates[i-1]){
				current.add(candidates[i]);
				helper(candidates, target-candidates[i], list, i+1, current);
				current.remove(current.size()-1);
			}
		}
	}
}
