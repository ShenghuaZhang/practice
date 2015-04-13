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
    public static boolean isValidSudoku(char[][] board) {
    	Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.' && map.containsKey(board[i][j]))    return false;
                else map.put(board[i][j], j);
            }
            map.clear();
            for(int j=0; j<9; j++){
                if(board[j][i]!='.' && map.containsKey(board[j][i]))    return false;
                else map.put(board[j][i], j);
            }
            map.clear();
        }
        
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                for(int k=i; k<i+3; k++){
                    for (int l=j; l<j+3; l++){
                        if(board[k][l]!='.' && map.containsKey(board[k][l]))    return false;
                        else map.put(board[k][l], k);
                    }
                }
                map.clear();
            }
        }

        return true;
    }
}
