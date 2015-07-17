package Math;

/**
 * 65
 * https://leetcode.com/problems/valid-number/
 * 
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * 
 * 
 * ".1" true
 * "." false
 * "3." true
 * ".." false
 * ".e4" false
 * "4e+" false
 * "-." false
 * "+.8" true
 * "6e6.5" false
 * 
 * @author kajia
 *
 */


public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isNumber("2e+"));

	}
    public static boolean isNumber(String s) {
    	if (s == null) {
    		return false;
    	}
        s = s.trim();
        if (s.length() == 0) {
        	return false;
        }
        boolean dotflag = false;
        boolean eflag = false;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '.' && !dotflag && !eflag && ( i != 0 &&(Character.isDigit(s.charAt(i-1))) || (i != s.length()-1 && Character.isDigit(s.charAt(i+1))) )) {
        		dotflag = true;
        		continue;
        	} else if ((c == '+' || c == '-') && (i == 0 ||(i != 0 && (s.charAt(i-1) == 'e' ||s.charAt(i-1) == 'E'))) && (i != s.length()-1 && (Character.isDigit(s.charAt(i+1)) || s.charAt(i+1) == '.'))) {
        		continue;
        	} else if ((c == 'e' || c == 'E') && !eflag && i != 0 && i != s.length()-1) {
        		eflag = true;
        		continue;
        	} else if (Character.isDigit(c)) {
        		continue;
        	} else{
        		return false;
        	}
        }
        return true;
    }
}
