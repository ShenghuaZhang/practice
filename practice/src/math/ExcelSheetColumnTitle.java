package math;

/**
 * 168
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * @author yili3
 * 
 * #ExcelSheetColumnNumber
 *
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n){
		StringBuilder sb = new StringBuilder();
		while(n>0){
			sb.append((char)(--n%26+'A'));
			n = n/26;
		}
		
		return sb.reverse().toString();
	}
}
