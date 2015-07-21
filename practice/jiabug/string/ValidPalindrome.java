package string;

/**
 * 125
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author jiakangze
 *
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean isPalindrome(String s) {
    	if (s == null) {
    		return false;
    	}
    	
    	/*do not use this part
    	if (s.length() == 0) {
    		return true;
    	}*/
    	
        int first = 0;
        int last = s.length()-1;
        
        while (first < last) {// do not use !=  .....................
        	while (first < last && !Character.isLetterOrDigit(s.charAt(first))) {
        		first++;
        	}
        	while (first < last && !Character.isLetterOrDigit(s.charAt(last))) {
        		last--;
        	}
        	
        	if (Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))) {
        		return false;
        	}
        	first++;
        	last--;
        }
        return true;
    }
}
