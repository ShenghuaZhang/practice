package dynamicProgramming;
/**
 * 63
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * Follow up for "#UniquePaths":
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * 	[0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * @author yili3
 *
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] unique = new int[m][n];
        
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(obstacleGrid[i][j]==1)	unique[i][j] = -1;
        		else if(i==0 || j==0){
        			if(j!=0 && unique[i][j-1]==-1)	unique[i][j] = -1;
        			else if(i!=0 && unique[i-1][j]==-1)	unique[i][j] = -1;
        			else unique[i][j] = 1;
        		}
        		else{
        			int left = unique[i-1][j]>0?unique[i-1][j]:0;
        			int up = unique[i][j-1]>0?unique[i][j-1]:0;
        			unique[i][j] = left+up;
        		}
        	}
        }
        
        return unique[m-1][n-1]>0?unique[m-1][n-1]:0;
    }
}
