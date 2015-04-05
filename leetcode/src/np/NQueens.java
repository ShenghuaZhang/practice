package np;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * 
 * The n-queens puzzle is the problem of placing n queens on an nxn chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * @author carllee1991
 *
 */
public class NQueens {
	static int num = 0;
	public static List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
		helper(n, 0, new int[n], res);
		helperII(n, 0, new int[n]);// return num;
		return res;
	}

	private static void helper(int n, int row, int[] columnForRow, List<String[]> res) {
		if (row == n) {
			String[] item = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder strRow = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (columnForRow[i] == j)
						strRow.append('Q');
					else
						strRow.append('.');
				}
				item[i] = strRow.toString();
			}
			res.add(item);
			System.out.println(Arrays.toString(item));
			return;
		}
		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (check(row, columnForRow)) {
				helper(n, row + 1, columnForRow, res);
			}
		}
	}
	
	private static void helperII(int n, int row, int[] columnForRow) {
		if (row == n) {
			num++;
			return;
		}
		for (int i = 0; i < n; i++) {
			columnForRow[row] = i;
			if (check(row, columnForRow)) {
				helperII(n, row + 1, columnForRow);
			}
		}
	}

	private static boolean check(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if (columnForRow[row] == columnForRow[i]
					|| Math.abs(columnForRow[row] - columnForRow[i]) == row - i)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		solveNQueens(4);
	}
}
