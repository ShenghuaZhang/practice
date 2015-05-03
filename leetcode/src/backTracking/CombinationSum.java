package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 5.3 39
 * https://leetcode.com/problems/combination-sum/
 * 
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * @author yili3
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> list = new ArrayList<>();
		if(candidates==null || candidates.length==0)	return list;
		
		Arrays.sort(candidates);
		
		
		return list;
	}
}
