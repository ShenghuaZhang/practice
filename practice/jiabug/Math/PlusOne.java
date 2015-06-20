package Math;

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

}
