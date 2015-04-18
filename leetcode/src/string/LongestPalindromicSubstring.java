package string;


public class LongestPalindromicSubstring {
	// best answer without extra space
	public static String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 1; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i - 1);
			int len2 = expandAroundCenter(s, i, i);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	private static int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
