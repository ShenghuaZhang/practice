package dynamicProgramming;
/**
 * 64
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * @author yili3
 *
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int[][] minSum = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0)
					minSum[0][0] = grid[0][0];
				else if (i == 0)
					minSum[i][j] = minSum[i][j - 1] + grid[i][j];
				else if (j == 0)
					minSum[i][j] = minSum[i - 1][j] + grid[i][j];
				else
					minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1])
							+ grid[i][j];
			}
		}

		return minSum[grid.length - 1][grid[0].length - 1];
	}
}
