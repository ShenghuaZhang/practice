package Math;

import java.util.Arrays;

/**
 * 66
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author jiakangze
 *
 */


public class PlusOne {

	public static void main(String[] args) {
		int[] number = new int[]{9,9};
		int[] result = plusOne(number);
		for (int i = 0; i < result.length; i++ ) {
			System.out.println(result[i]);
		}
		Object arr[] = new Object[10];
		boolean empty = true;
		for (int i=0; i<arr.length; i++) {
		  if (arr[i] != null) {
		    empty = false;
		    break;
		  }
		}
		System.out.println("empty: " + empty);
		int[] a = new int[]{1,3};
		int[] b = new int[]{1,3};
		System.out.println("a == b:" + Arrays.equals(a, b));
		
		String s1 = "abcd";
		String s2 = "abcd";
		s1 = "abc";
		s1 = new String("ab");
		String s3 = new String("abcd");
		String s4 = new String("abcd");
		StringBuilder s5 = new StringBuilder("abc");
		StringBuilder s6 = new StringBuilder("abc");
		StringBuffer s7 = new StringBuffer("abc");
		StringBuffer s8 = new StringBuffer("abc");
		System.out.println("s1: " + s1);
		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s3 == s4: " + (s3 == s4));
		System.out.println("s3.equals(s4): " + (s3.equals(s4)));
		System.out.println("s5 == s6: " + (s5.equals(s6)));
		System.out.println("s7 == s8: " + (s7.equals(s8)));

	}
	
	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return null;
		}
		int length = digits.length;
		int carry = (digits[length - 1] + 1) / 10;
		digits[length - 1] = (digits[length - 1] + 1) % 10;
		
		for (int i = length-2; i>=0; i--) {
			int temp = digits[i] + carry;
			digits[i] = temp % 10;
			carry = temp / 10;
		}
		if (carry == 0) { 
			return digits;
		} else {
			int[] res = new int[length+1];
			for (int j = length; j > 0; j--) {
				res[j] = digits[j-1];
			}
			res[0] = carry;
			return res;
		}
    }
	
	public static int[] plusOne_yi(int[] digits) {
		for (int i = digits.length-1; i >= 0; i--) {
			digits[i] = digits[i] + 1;
			if (digits[i] <= 9) {
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] res= new int[digits.length+1];
		res[0] = 1;
		for (int j = 0; j < digits.length; j++) {
			res[j+1] = digits[j];
		}
		return res;
	}

}
