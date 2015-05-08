package google;

import java.util.Arrays;
/**
 * Give you a range like range = 5 and give you a unsorted array
 * find a window which no bigger than this range and contain most numbers
 * 
 * @author carllee1991
 *
 */
public class MaximumRangeNumber {
	/* Two pointer:
	 * #TwoSumII #TrappingRainWater
	 * #LongestSubstringWithoutRepeatingCharacters
	 * #LongestSubstringWithAtMostTwoDistinctCharacters
	 * #ContainerWithMostWater
	 * */
	public static int maximumRange(int[] A, int size) {
		Arrays.sort(A);
		int first = 0, second = 0, cnt = 0;

		while (second < A.length) {
			if (A[second] - A[first] <= size) {
				second++;
				cnt = Math.max(cnt, second - first);
			} else
				first++;
		}

		return cnt;
	}
}
