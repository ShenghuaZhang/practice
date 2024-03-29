package math;

/**
 * 171
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Related to question Excel Sheet Column Title.
 * Given a column title as appear in an Excel sheet,
 * return its corresponding column number.
 * 
 * @author yili3
 * 
 * #ExcelSheetColumnTitle #DecimalToOtherRadix
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s){
		int num = 0;
		for(char c:s.toCharArray())
			num = num*26+(c-'A'+1);
		return num;
	}
	
	public static void main(String[] args){
		System.out.print(titleToNumber("DA"));
	}
}
