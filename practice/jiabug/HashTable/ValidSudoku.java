package HashTable;

import java.util.HashSet;

/**
 * 36
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * @author kajia
 *
 */

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
        	HashSet<Character> row = new HashSet<Character>();
        	HashSet<Character> column = new HashSet<Character>();
        	HashSet<Character> block = new HashSet<Character>();
        	
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.' && !row.add(board[i][j]) ) {
        			return false;
        		}
        		if (board[j][i] != '.' && !column.add(board[j][i])) {
        			return false;
        		}
        		if (board[j/3 + (i/3)*3][j%3 + (i%3)*3] != '.' && !block.add(board[j/3 + (i/3)*3][j%3 + (i%3)*3])) {
        			return false;
        		}
        		
        	}
        }
        return true;
    }
}
