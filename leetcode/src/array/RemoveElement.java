package array;

/**
 * https://leetcode.com/problems/remove-element/
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 */

import java.util.Arrays;

public class RemoveElement {
	/*
	 * Did not get the meaning of this question.
	 */
	public static int removeElement(int[] A, int elem) {
		int length = A.length, temp = -1, rs = length;
		for (int i = 0; i < length; i++) {
			if (A[i] == elem) {
				if (temp != -1) {
					RotatedArray.swap(A, temp, i);
					for (; temp < length && A[temp] == elem && temp < i; temp++)
						;
				}
				rs--;
			} else if (A[i] != elem && temp == -1)
				temp = i;
		}
		RotatedArray.reverse(A, 0, length - 1);
		return rs;
	}
	/*
	 * right answer
	 */
	public static int removeElementII(int[] A, int elem) {
		int index = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] != elem)
				A[index++] = A[i];
		return index;
	}

	public static void main(String[] args) {
		int[] A = { 22, 1, 1, 1, 1, 2, 1, 1, 11, 3, 4, 51, 1, 1, 1 };
		removeElementII(A, 1);
		System.out.println(Arrays.toString(A));
	}
}
