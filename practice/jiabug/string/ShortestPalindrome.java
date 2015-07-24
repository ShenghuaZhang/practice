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
		
		System.out.println(shortestPalindrome("aba"));
		

	}
    public static String shortestPalindrome_KMP(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        
        StringBuilder total = new StringBuilder(s);
        StringBuilder rev = new StringBuilder(s);
        total.append('#').append(rev.reverse()).append('@');
        System.out.println(total);
        
        int[] next = new int[total.length()];
        
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < total.length()-1) {
        	if(k == -1 || total.charAt(j) == total.charAt(k)) {
        		k++;
        		j++;
        		if (total.charAt(j) != total.charAt(k)) {
        			next[j] = k;
        		} else {
        			next[j] = next[k];
        		}
        	} else {
        		k = next[k];
        	}
        }
        StringBuilder res = new StringBuilder(s);
        System.out.println(next[total.length()-1]);
        res.insert(0, rev.substring(0, rev.length() - next[total.length()-1]));
        return res.toString();
    }
    
    public static String shortestPalindrome(String s) {
    	if (s == null || s.length() <=1) {
    		return s;
    	}
    	
    	int len = s.length();
    	int mid = len/2;
    	String res = "";
    	
    	for (int i = mid; i >= 1; i--) {
    		if (s.charAt(i) == s.charAt(i-1)) {
    			if ((res = helper(s, i-1, i)) != null) {
    				return res;
    			}
    		} else {
    			if ((res = helper(s, i-1, i-1)) != null) {
    				return res;
    			}
    		}
    	}
    	return res;
    }
    
    public static String helper(String s, int l, int r) {
    	int i = 1;
    	for (; l-i >= 0; i++) {
    		if (s.charAt(l-i) != s.charAt(r+i)) {
    			break;
    		}
    	}
    	if (l-i >= 0) {
    		return null;
    	}
    	StringBuilder res = new StringBuilder(s.substring(r+i, s.length()));
    	
    	return res.reverse().append(s).toString();
    }
}
