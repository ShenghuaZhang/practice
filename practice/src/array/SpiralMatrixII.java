package array;
/**
 * 59
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example, Given n = 3, You should return the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 8, 9, 4 ],
 * 	[ 7, 6, 5 ]
 * ]
 * 
 * @author carllee1991
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int current = 1;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++)
				matrix[i][j] = current++;
			for (int j = i; j < n - 1 - i; j++)
				matrix[j][n - 1 - i] = current++;
			for (int j = n - 1 - i; j > i; j--)
				matrix[n - 1 - i][j] = current++;
			for (int j = n - 1 - i; j > i; j--)
				matrix[j][i] = current++;
		}
		if (n % 2 == 1)
			matrix[n / 2][n / 2] = current;
		return matrix;
	}
}
