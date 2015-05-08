package array;

/**
 * https://leetcode.com/problems/4sum/
 * 
 * Given an array S of n integers,
 * are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * See this with combination:
 * #TwoSum#TwoSumII#TwoSumIII#ThreeSum#ThreeSumClosest#FourSum
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> list = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int start = j + 1, end = num.length - 1;
				while (start < end) {
					int sum = num[i] + num[j] + num[start] + num[end];
					if (sum > target)	end--;
					else if (sum < target)	start++;
					else {
						List<Integer> curList = new ArrayList<>(Arrays.asList(
								num[i], num[j], num[start++], num[end--]));
						set.add(curList);
					}
				}
			}
		}
		list.addAll(set);
		return list;
	}
}
