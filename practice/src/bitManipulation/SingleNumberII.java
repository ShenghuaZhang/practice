package bitManipulation;
/**
 * 137
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Given an array of integers,
 * every element appears three times except for one. Find that single one.
 * 
 * @author yili3
 *
 */
public class SingleNumberII {
	// I like this best, less extra space and higher efficiency.
	public static int singleNumberBetter(short[] A) {
		int zero = ~0, one = 0, two = 0;
		for (short i : A) {
			int temp = two;
			two = (one & i) | (two & ~i);
			one = (zero & i) | (one & ~i);
			zero = (zero & ~i) | (temp & i);
		}
		return one;
	}

	public static int singleNumberK(int[] A, int k, int l) {
		int[] mem = new int[k];
		mem[0] = ~0;
		for (int i : A) {
			int temp = mem[k - 1];
			for (int j = k - 1; j > 0; j--) {
				mem[j] = (mem[j - 1] & i) | (mem[j] & ~i);
			}
			mem[0] = (mem[0] & ~i) | (temp & i);
		}
		return mem[l];
	}

	public static void main(String[] args) {
		short[] test = new short[] { (short) 0b1111111111111111,
				(short) 0b1010000101000101, (short) 0b1010000101000101,(short) 0b1010000101000101 };
		System.out.println(singleNumberBetter(test));
	}
}
