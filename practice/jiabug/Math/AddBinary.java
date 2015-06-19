package Math;

/**
 * 67
 * https://leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * @author kajia
 *
 */

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary_bad("1000", "11"));
		System.out.println(addBinary_bad("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
		System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

	}
	//this method can not solve the big number
	     //Input:
		//"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
		//Output:
		//"1100011110011010010011000000000"
		//Expected:
		//"110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
    public static String addBinary_bad(String a, String b) {
        int a_int = 0;
        int b_int = 0;
        for (int i = 0; i < a.length(); i++) {
        	if (a.charAt(i) =='1') {
        	    a_int = a_int * 2 + 1;
        	} else {
        		a_int = a_int * 2 ;
        	}
        }
        for (int j = 0; j < b.length(); j++) {
        	if (b.charAt(j) =='1') {
        	    b_int = b_int * 2 + 1;
        	} else {
        		b_int = b_int * 2 ;
        	}
        }
        return Integer.toBinaryString(a_int + b_int);
    }
    
    
    //correct answer
    public static String addBinary(String a, String b) {
    	if (a == null || a.length() == 0) {
    		return b;
    	}
    	if (b == null || b.length() == 0) {
    		return a;
    	}
    	
    	int a_length = a.length() - 1;
    	int b_length = b.length() - 1;
    	int carry = 0;
    	int digit = 0;
    	StringBuilder res = new StringBuilder();
    	
    	while (a_length >= 0 && b_length >= 0) {
    		int temp = a.charAt(a_length) - '0' + b.charAt(b_length) - '0' + carry;
    		carry = temp / 2;
    		digit = temp % 2;
    		res.append(digit);
    		a_length--;
    		b_length--;
    	}
    	
    	while (a_length >= 0) {
    		int temp = a.charAt(a_length) - '0' + carry;
    		carry = temp / 2;
    		digit = temp % 2;
    		res.append(digit);
    		a_length--;
    	}
    	
    	while (b_length >= 0) {
    		int temp = b.charAt(b_length) - '0' + carry;
    		carry = temp / 2;
    		digit = temp % 2;
    		res.append(digit);
    		b_length--;
    	}
    	
    	if (carry > 0) {
    		res.append(carry);
    	}
    	
    	return res.reverse().toString();//do not forget to reverse the string
    	
    }
}
