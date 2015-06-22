package Math;

/**
 * 8
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * 
 * @author jiakangze
 *
 */


public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi("      010"));

	}
	
    public static int myAtoi(String str) {
        if (str == null) {
        	return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
        	return 0;
        }
        int i = 0;
        boolean signflag = true;
        if (str.charAt(i) == '-') {
        	i++;
        	signflag = false;
        } else if (str.charAt(i) == '+'){
        	i++;
        }
        long res = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') { 
        	res = res * 10 + (str.charAt(i) - '0' - 0);
        	if (signflag && res >= Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	} else if (!signflag && res >= (Integer.MAX_VALUE + 1L)) {//Integer.MAX_VALUE + 1 will overflow
        		return Integer.MIN_VALUE;
        	}
        	i++;
        }
        
        return (int)(signflag ? res : -1 * res);
    }

}
