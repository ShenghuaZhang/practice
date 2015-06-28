package Math;

import java.util.ArrayList;

/**
 * 60
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * 
 * The set [1,2,3,�,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author kajia
 *
 */


public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3,6));
		

	}
	public static String getPermutation(int n, int k) {
		if (n <= 0) {
			return "";
		}
		
		StringBuilder res = new StringBuilder();

		k--;//then we can start the index of arraylist with 0. (line 61)
		
		int factorial = 1;
		for (int i = 2; i < n; i++) {
			factorial *= i;
		}
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			array.add(i);
		}
		
		int round = n - 1;
		
		while (round >= 0) {
			int index = k / factorial;
			k %= factorial;
			res.append(array.get(index));
			array.remove(index);
			if (round > 0) {
				factorial /= round;
			}
			round --;
		}
		return res.toString();
	}

}
