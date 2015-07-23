package string;

/**
 * 214
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * 
 * @author kajia
 *
 */

public class ShortestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortestPalindrome("abcd"));
		
		String s = "ab";
		StringBuilder res = new StringBuilder(s);
		//System.out.println(res.substring(0,2));

	}
    public static String shortestPalindrome(String s) {
    	if (s == null) {
    		return null;
    	}
    	if (s.length() == 0) {
    		return "";
    	}
    	StringBuilder res = new StringBuilder(s);
    	for (int i = res.length()-1; i >= 0; i--) {
    		if (isPalindrome(res.substring(0, i+1))) {
    			i++;
    			while (i < s.length()) {
    				res.insert(0, s.charAt(i));
    				i++;
    			}
    			return res.toString();
    		}
    	}
    	return "";
    	
    }
    private static boolean isPalindrome(String s) {
    	int pre = 0;
    	int last = s.length() - 1;
    	while (pre < last) {
    		if (s.charAt(pre) != s.charAt(last)) {
    			return false;
    		}
    		pre++;
    		last--;
    	}
    	return true;
    }
    

}
