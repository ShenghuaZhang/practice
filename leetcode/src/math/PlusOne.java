package math;

/**
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
	/*
	 * When given list.
	 */
	public static void plusOne(List<Integer> digits) {
		for (int i = digits.size() - 1; i >= 0; i--) {
			int temp = digits.get(i) + 1;
			if (temp <= 9) {
				digits.set(i, temp);
				return;
			} else
				digits.set(i, 0);
		}
		digits.add(0, 1);
	}
	
	/*
	 * When given array.
	 */
	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + 1;
			if (temp <= 9) {
				digits[i] = temp;
				return digits;
			} else
				digits[i] = 0;
		}
		int[] ret = new int[digits.length + 1];
		ret[0] = 1;
		for (int i = 0; i < digits.length; i++)
			ret[i + 1] = digits[i];
		return ret;
	}

	public static void main(String[] arsgs) {
		List<Integer> digits = new ArrayList<>(Arrays.asList(9,9,9));
		plusOne(digits);
		System.out.println(digits);
		
		System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
	}
}
