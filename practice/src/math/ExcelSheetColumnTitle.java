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
	public static String convertToTitle(int n){
		StringBuilder sb = new StringBuilder();
		while(n>0){
			sb.insert(0, (char)(n%26-1+'A'));
			n = n/26;
		}
		
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println(convertToTitle(105));
	}
}
