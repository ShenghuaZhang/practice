package string;
/**
 * 5
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 * 
 * @author yili3
 * 
 * #Candy #TrappingRainWater
 *
 */

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        int start = 0, end = 0;
		for(int i=0; i<s.length(); i++){
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len>end-start+1){
				start = i-(len-1)/2;
				end = i+len/2;
			}
		}
		return s.substring(start, end+1);
	}
	private int expandAroundCenter(String s, int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return right-left-1;
	}
	
	public String longestPalindromeDP(String s) {
		boolean[][] palin = new boolean[s.length()][s.length()];
		int start = 0, end = 0;
		for (int i = 0; i <s.length(); i++)
			for (int j = 0; j <= i; j++)
				if (s.charAt(i)==s.charAt(j) && (i-j<2||palin[i-1][j+1])) {
					palin[i][j] = true;
					if (end-start<i-j){	
						start = j;	end = i;
					}
				}

		return s.substring(start, end+1);
	}
}
