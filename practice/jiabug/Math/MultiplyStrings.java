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
		System.out.println(multiply("8791743912739","9911999999"));
		System.out.println(multiply_jiuzhang("8791743912739","9911999999"));

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
        		
        		if (i - j <= num2.length()) {
        			num += (int)(num1.charAt(j-1) - '0') * (int)(num2.charAt(i-1-j) - '0');
        		} else {
        			break;//more efficient
        		}
        		
        		
        	}
        	if (i != 1 || num > 0) {
    			res.append(num%10);//the most significant bit of result only can come from carry.
    			//so, if num == 0, the carry will be 0, then we do not need to continue.
    		}
    		
    		num /= 10;
        }
        return res.reverse().toString();
    }
    
    public static String multiply_jiuzhang(String num1, String num2) {
    	if (num1 == null || num2 == null) {
    		return "";
    	}
    	
    	int len1 = num1.length();
    	int len2 = num2.length();
    	int len3 = len1 + len2;
    	int i, j, product, carry;
    	int[] res = new int[len3];
    	for (i = len1 - 1; i >= 0; i--) {
    		carry = 0;
    		for (j = len2 - 1; j >= 0; j--) {
    			product = res[i + j + 1] + carry + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
    					//Character.digit(num1.charAt(i), 10) * Character.digit(num2.charAt(j), 10);
    			res[i + j + 1] = product % 10;
    			carry = product / 10;
    		}
    		res[i + j + 1] = carry;
    	}
    	
    	i = 0;
    	while (i < len3 - 1 && res[i] == 0) {
    		i++;
    	}
    	StringBuilder result = new StringBuilder();
    	while (i < len3) {
    		result.append(res[i++]);
    	}
    	return result.toString();

    	
    }

}
