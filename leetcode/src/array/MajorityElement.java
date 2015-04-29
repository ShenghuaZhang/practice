package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169
 * https://leetcode.com/problems/majority-element/
 * 
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2⌋  times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * @author yili3
 *
 */
public class MajorityElement {
	public int majorityElementBest(int[] nums) {
		int cnt = 0, previous = nums[0];
		for (int i : nums) {
			if (i == previous)
				++cnt;
			else if (cnt > 1)
				--cnt;
			else
				previous = i;
		}
		return previous;
	}

	public int majorityElement(int[] num) {
		int length = num.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : num) {
			if (map.containsKey(i)) {
				int cnt = map.get(i);
				map.put(i, cnt + 1);
			} else
				map.put(i, 1);
		}

		for (int i : num)
			if (map.get(i) > (length / 2))
				return i;

		return -1;
	}
}
