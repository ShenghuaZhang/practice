package string;
/**
 * 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author carllee1991
 * 
 * #MinimumWindowSubstring
 * #SubstringWithConcatenationOfAllWords
 * #LongestSubstringWithAtMostTwoDistinctCharacters
 * 
 */
import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s){
		int[] exist = new int[256];
		Arrays.fill(exist, -1);
		int maxLen = 0, start=0;
		
		for(int cur=0; cur<s.length(); cur++){
			if (exist[s.charAt(cur)] >= start)	start = exist[s.charAt(cur)]+1;
			else maxLen = Math.max(cur-start+1, maxLen);
			exist[s.charAt(cur)] = cur;
		}
		return maxLen;
	}
}
