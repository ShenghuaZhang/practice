package google;

import java.util.Arrays;

public class MaximumRangeNumber {
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
	
	public static void main(String[] args){
		int[] A = {-1, 3, 5, 12, 34, -23, 45, 7, 10, 13};
		System.out.print(maximumRange(A, 10));
	}
}
