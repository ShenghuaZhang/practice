package Math;

/**
 * 9
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * 
 * @author jiakangze
 *
 */


public class PalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome(1001));
	}
	//this method used temp which is extra space.!!!!!!!
    public static boolean isPalindrome_bad(int x) {
        int temp = x;
        int reverse = 0;
        
        while (temp > 0) {
        	reverse = reverse * 10 + temp%10;
        	temp /= 10;
        }
        
        return reverse == x;
    }
    
    public static boolean isPalindrome(int n) {
    	if (n < 0) {
    		return false;
    	}
    	
    	int div = 1;
    	//write n/dive in the estimate statement, let the code neat same with factorial trailing question.
    	while (n/div >= 10) {//if we do not add =, 1001 will be false
    		div *= 10;
    	}
    	System.out.println(div);
    	while (n > 0) {
    		int l = n / div;
    		int r = n % 10;
    		
    		if (l != r) {
    			return false;
    		}
    		
    		n = (n % div) / 10;
    		div /= 100;
    	}
    	return true;
    	
    }

}
