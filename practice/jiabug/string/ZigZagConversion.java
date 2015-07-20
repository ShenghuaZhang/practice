package string;

/**
 * 6
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author kajia
 *
 */

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static String convert(String s, int numRows) {
    	if (s == null || s.length() == 0 || numRows <= 0) {
    		return "";
    	}
    	if (numRows == 1) {
    		return s;
    	}
    	int size = 2 * numRows - 2;
    	
    	StringBuilder res = new StringBuilder();
    	
    	for (int i = 0; i < numRows; i++) {
    		for (int j = i; j < s.length(); j += size) {//if numRows == 1, this will be end loop
    			res.append(s.charAt(j));
    			if (i != 0 && i != numRows - 1 && j + size - 2*i < s.length()) {
    				res.append(s.charAt(j+size-2*i));
    			}
    		}
    	}
    	return res.toString();
        
    }

}
