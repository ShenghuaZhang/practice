package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * @author yili3
 *
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                Map<Character, Integer> map = new HashMap<>();
                if(map.containsKey(board[i][j]))    return false;
                else map.put(board[i][j], j);
            }
        }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                Map<Character, Integer> map = new HashMap<>();
                if(map.containsKey(board[i][j]))    return false;
                else map.put(board[i][j], j);
            }
        }
        
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                for(int k=i; k<i+2; k++){
                    for (int l=j; l<j+2; l++){
                        Map<Character, Integer> map = new HashMap<>();
                        if(map.containsKey(board[k][l]))    return false;
                        else map.put(board[k][l], k);
                    }
                }
            }
        }
        
        return true;
    }
}
