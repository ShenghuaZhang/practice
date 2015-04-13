package np;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * @author yili3
 * 
 * #NQueens
 *
 */
public class SudokuSolver {
	public static boolean solveSudoku(char[][] board){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(board[i][j] == '.'){
					List<Character> list = possibleNumber(board, i, j);
					if(list.size()==0)	return false;
					for(int k=0; k<list.size(); k++){
						board[i][j] = list.get(k);
						if(solveSudoku(board))	return true;
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}
	private static List<Character> possibleNumber(char[][] board, int row, int column){
		List<Character> list = new ArrayList<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
		for(int i=0, k=1; i<9 && k<9; i++){
			if(board[row][i]!='.')	list.remove((Character)board[row][i]);
			if(board[i][column]!='.')	list.remove((Character)board[i][column]);
		}
		int rowMod = row%3, columnMod = column%3;
		for(int i=row-rowMod; i<=row+(2-rowMod); i++){
			for(int j=column-columnMod; j<=column+(2-columnMod); j++){
				if(board[i][j]!='.')	list.remove((Character)board[i][j]);
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		String[] ss = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] board = new char[9][9];
		for(int i=0; i<9; i++)	board[i] = ss[i].toCharArray();

		solveSudoku(board);
		for(int k=0; k<9; k++){
			for(int l=0; l<9; l++){
				System.out.print(board[k][l]);
			}
			System.out.println();
		}System.out.println();
	}
}
