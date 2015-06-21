package Math;

/**
 * 171
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Related to question Excel Sheet Column Title.
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * @author jiakangze
 * 
 * #ExcelSheetColumnTitle
 */

public class ExcelSheetColumnNumber {
    //ASCII    "A" is 65, "a" is 97
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ExcelSheetColumnNumber.titleToNumber("YZ"));

	}
	
	public static int titleToNumber (String s) {
		int number = 0;
		for (int i = 0; i < s.length(); i++){
			number = number * 26 + (s.charAt(i) - 'A' + 1);
		}
		return number;
	}

}