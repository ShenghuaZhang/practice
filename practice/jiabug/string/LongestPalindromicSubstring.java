package string;

/**
 * 5
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author jiakangze
 *
 */

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        
        int len = 0;
        String res = "";
        for (int i = 0; i <= 2 * s.length() - 1; i++) {
        	int left = i/2;
        	int right = i/2;
        	
        	if (i % 2 == 1) {
        		right ++;
        	}
        	
        	String str = lengthOfString(s, left, right);
        	if (len < str.length()) {
        		len = str.length();
        		res = str;
        	}
        }
        return res;
    }
    
    private static String lengthOfString(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}
    	return s.substring(++left, right);
    }

    public static String longestPalindrome_yi(String s) {
        int start = 0;
        int end = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
        	int len1 = helper(s, i, i);
        	int len2 = helper(s, i, i+1);
        	
        	int len = Math.max(len1, len2);
        	
        	if (len > longest) {
        		start = i - (len-1) / 2;
        		end = i + len/2;
        		longest = len;
        	}
        }
        return s.substring(start, end+1);
    }
    
    private static int helper(String s, int start, int end) {
    	while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
    		start--;
    		end++;
    	}
    	return end - start - 1;
    }
}

