package dynamicProgramming;

import java.util.Stack;

/**
 * 85
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 * 
 * @author yili3
 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix){
		int max = 0;
		for(int i=0; i<matrix.length; i++){
			Stack<Integer> stack = new Stack<>();
			for(int j=0; j<matrix[i].length; j++){
				if(stack.empty()){
					stack.push(j);
					continue;
				}
				int height = getOneHeight(matrix, i, j);
				while(!stack.empty() && getOneHeight(matrix, i, stack.peek())>height){
					int top = stack.pop();
					int topHeight = getOneHeight(matrix, i, top);
					max = Math.max(max, stack.empty()?topHeight*j:topHeight*(j-1-stack.peek()));
				}
				stack.push(j);
			}
			while(!stack.empty()){
				int top = stack.pop();
				int topHeight = getOneHeight(matrix, i, top);
				max = Math.max(max, stack.empty()?topHeight*matrix[i].length:topHeight*(matrix[i].length-stack.peek()-1));
			}
		}
		
		return max;
	}
	private int getOneHeight(char[][] matrix, int row, int column){
		int height = 0;
		for(int i=row; i>=0; i--){
			if(matrix[i][column]!='1') break;
			height++;
		}
		return height;
	}
}
