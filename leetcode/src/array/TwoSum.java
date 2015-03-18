/**
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 */

package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int size = numbers.length;
		for (int i = 0; i < size; i++) {
			if (map.containsKey(target - numbers[i]))
				return new int[] { map.get(target - numbers[i]) + 1, i + 1 };
			else
				map.put(numbers[i], i);
		}
		return null;
	}
}
