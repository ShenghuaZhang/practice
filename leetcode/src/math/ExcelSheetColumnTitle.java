package math;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * #ExcelSheetColumnNumber
 * 
 * @author yili3
 *
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n){
		StringBuilder sb = new StringBuilder();
		while(n!=0){
			n--;
			char c = (char)(n%26+'A');
			sb.append(c);
			n = n/26;
		}
		
		return sb.reverse().toString();
	}
}
