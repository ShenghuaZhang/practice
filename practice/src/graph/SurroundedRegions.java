package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 130
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * 		X X X X
 * 		X O O X
 * 		X X O X
 * 		X O X X
 * After running your function, the board should be:
 * 		X X X X
 * 		X X X X
 * 		X X X X
 * 		X O X X
 * 
 * @author yili3
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 1 || board[0].length <= 1)
			return;
		for (int i = 0; i < board[0].length; i++) {
			fillBFS(board, 0, i);					// first row
			fillBFS(board, board.length-1, i);	// last row
		}
		for (int i = 1; i < board.length-1; i++) {
			fillBFS(board, i, 0);					// first column
			fillBFS(board, i, board[0].length-1);// last column
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}
	
	// stack over flow error when to much data
	@SuppressWarnings("unused")
	private void dfsRecursion(char[][] board, int i, int j){
		if(board[i][j]=='O'){
			board[i][j] = '#';
			if(i>0)	dfsRecursion(board, i-1, j);
			if(j>0)	dfsRecursion(board, i, j-1);
			if(j<board[0].length-1)	dfsRecursion(board, i, j+1);
			if(i<board.length-1)	dfsRecursion(board, i+1, j);
		}
	}
	
	// BFS Iterative
	private void fillBFS(char[][] board, int i, int j) {
		if (board[i][j] != 'O')	return;
		board[i][j] = '#';
		Queue<Integer> queue = new LinkedList<>();
		// find a good way to save row and column in just one number
		int code = i * board[0].length + j;	
		queue.offer(code);
		
		while (!queue.isEmpty()) {
			code = queue.poll();
			int row = code / board[0].length;
			int col = code % board[0].length;
			if (row > 0 && board[row - 1][col] == 'O') {
				queue.offer((row - 1) * board[0].length + col);
				board[row - 1][col] = '#';
			}
			if (row < board.length - 1 && board[row + 1][col] == 'O') {
				queue.offer((row + 1) * board[0].length + col);
				board[row + 1][col] = '#';
			}
			if (col > 0 && board[row][col - 1] == 'O') {
				queue.offer(row * board[0].length + col - 1);
				board[row][col - 1] = '#';
			}
			if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
				queue.offer(row * board[0].length + col + 1);
				board[row][col + 1] = '#';
			}
		}
	}
	
	// DFS Iterative
	@SuppressWarnings("unused")
	private void fillDFS(char[][] board, int i, int j) {
		if (board[i][j] != 'O')	return;
		board[i][j] = '#';
		Stack<Integer> stack = new Stack<>();
		int code = i * board[0].length + j;
		stack.push(code);

		while (!stack.empty()) {
			code = stack.pop();
			int row = code / board[0].length;
			int column = code % board[0].length;
			if (row > 0 && board[row - 1][column] == 'O') {
				stack.push((row - 1) * board[0].length + column);
				board[row - 1][column] = '#';
			}
			if (column > 0 && board[row][column - 1] == 'O') {
				stack.push((row * board[0].length) + column - 1);
				board[row][column - 1] = '#';
			}
			if (row < board.length - 1 && board[row + 1][column] == 'O') {
				stack.push((row + 1) * board[0].length + column);
				board[row + 1][column] = '#';
			}
			if (column < board[0].length - 1 && board[row][column + 1] == 'O') {
				stack.push((row) * board[0].length + column + 1);
				board[row][column + 1] = '#';
			}
		}
	}
}
