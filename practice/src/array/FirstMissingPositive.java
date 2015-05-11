package array;

/**
 * 41
 * http://oj.leetcode.com/problems/first-missing-positive/
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * @author yili3
 *
 */

public class FirstMissingPositive {
	/**
	 * using counting sorted
	 * @param A: array
	 * @return first missing positive
	 */
	public static int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0)
			return 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
				i--;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}

		return A.length + 1;
	}
}
