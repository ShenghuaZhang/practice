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
		System.out.println(shortestPalindrome("aaaaaaa"));
		
		String s = "ab";
		StringBuilder res = new StringBuilder(s);
		res.insert(2, "e");
		//System.out.println(res.toString());

	}
    public static String shortestPalindrome(String s) {
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
        StringBuilder res = new StringBuilder(s);
        end++;
        while (end < res.length()) {
        	res.insert(start,res.charAt(end));
        	end += 2;
        }
        System.out.println("res: " + res);
        System.out.println("end: " + end);
        start--;
        while (start >= 0) {
        	res.insert(end, res.charAt(start));
        	start--;
        }
        return res.toString();
        
    }
    
    private static int helper(String s, int start, int end) {
    	while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
    		start--;
    		end++;
    	}
    	return end - start - 1;
    }

}
