package graph;
/**
 * 200
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Example 1:				Example 2:
 * 11110					11000
 * 11010					11000
 * 11000					00100
 * 00000					00011
 * Answer: 1				Answer: 3
 * 
 * @author yili3
 *
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)	return 0;
		int ret = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1'){
					ret++;
					dfs(grid, i, j);	
				}
			}
		}
		return ret;
	}

	public void dfs(char[][] grid, int i, int j) {
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			if (i > 0)	dfs(grid, i - 1, j);
			if (j > 0)	dfs(grid, i, j - 1);
			if (i < grid.length - 1)	dfs(grid, i + 1, j);
			if (j < grid[0].length - 1)	dfs(grid, i, j + 1);
		}
	}
}
