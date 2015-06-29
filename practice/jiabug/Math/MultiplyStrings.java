package Math;

/**
 * 43
 * https://leetcode.com/problems/multiply-strings/
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * 
 * @author jiakangze
 *
 */


public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("0","12"));

	}
	
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
        	return "";
        }
        
        if (num1.charAt(0) == '0') {//the most significant bit
        	return "0";
        }
        if (num2.charAt(0) == '0') {
        	return "0";
        }
        	
        
        StringBuilder res = new StringBuilder();
        int num = 0;
        
        for (int i = num1.length() + num2.length(); i >=1; i--) {
        	
        	for (int j = Math.min(i-1, num1.length()); j>= 1; j--) {
        		
        		if(i - j <= num2.length()) {
        			num += (int)(num1.charAt(j-1) - '0') * (int)(num2.charAt(i-1-j) - '0');
        		}
        		
        		
        	}
        	if (i != 1 || num > 0) {
    			res.append(num%10);
    		}
    		
    		num /= 10;
        }
        return res.reverse().toString();
    }

}
