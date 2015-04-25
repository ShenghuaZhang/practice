package graph;
/**
 * https://leetcode.com/problems/word-search/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 * 		["ABCE"],
 * 		["SFCS"],
 * 		["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author yili3
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                 if(helper(board, word, i, j, 0, used))  return true;
            }
        }
        return false;
    }
    private boolean helper(char[][]board, String word, int i, int j, int index, boolean[][] used){
        if(!used[i][j] && board[i][j]==word.charAt(index)){
        	used[i][j] = true;
            if(index==word.length()-1)  return true;
            if(i>0 && helper(board, word, i-1, j, index+1, used)) return true;
            if(j>0 && helper(board, word, i, j-1, index+1, used)) return true;
            if(i<board.length-1 && helper(board, word, i+1, j, index+1, used))    return true;
            if(j<board[0].length-1 && helper(board, word, i, j+1, index+1, used)) return true;
            used[i][j] = false;
        }
        return false;
    }
}
