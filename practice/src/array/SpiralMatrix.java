package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * [ 
 * 	 [ 1, 2, 3 ], 
 *   [ 4, 5, 6 ], 
 *   [ 7, 8, 9 ] 
 * ]
 * You should return	[1,2,3,6,9,8,7,4,5].
 * 
 * @author carllee1991
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0)	return list;
		int min = Math.min(matrix.length, matrix[0].length);
		int level = min/2;
		for (int i = 0; i < level; i++) {
			for(int j=i; j<matrix[0].length-1-i; j++)
				list.add(matrix[i][j]);
			for(int j=i; j<matrix.length-1-i; j++)
				list.add(matrix[j][matrix[0].length-1-i]);
			for(int j=matrix[0].length-1-i; j>i; j--)
				list.add(matrix[matrix.length-1-i][j]);
			for(int j=matrix.length-1-i; j>i; j--)
				list.add(matrix[j][i]);
		}
		if(min%2==1){
			if(matrix.length<matrix[0].length){
				for(int i=level; i<matrix[0].length-level;i++)
					list.add(matrix[level][i]);
			}else{
				for(int i=level; i<matrix.length-level; i++)
					list.add(matrix[i][level]);
			}
		}
		return list;
	}
}
