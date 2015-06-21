package Math;

/**
 * 168
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *   ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB 
 *  
 *  
 * @author kajia
 * #ExcelSheetColumnNumber
 */

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		
		System.out.println(convertToTitle(26*26));
		
	}
    public static  String convertToTitle(int n) {
        if (n < 1) {
        	return null;
        }
        
        StringBuilder res = new StringBuilder();
        /*
        while (n > 0) {
        	if (n % 26 != 0) {
        		res.append((char) ('A' + n % 26 - 1));
        		n -= n % 26;
        		n /= 26; 
        	} else {
        		res.append('Z');
        		n -= 26;
        		n /= 26;
        	}
        }*/
        
        //better
        while (n > 0) {
        	n--;
        	res.append((char)('A' + n%26));
        	n /= 26;
        }
        
        
        return res.reverse().toString();
    }
    
    public static String convertToTitle_neat(int n) {
    	StringBuilder res = new StringBuilder();
    	while (n > 0) {
    		n--;
    		res.insert(0, (char)('A' + n%26));
    		n /= 26;
    	}
    	return res.toString();
    }
}
