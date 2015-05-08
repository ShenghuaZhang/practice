package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 76
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T,
 * return the empty string "".
 * If there are multiple such windows,
 * you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * @author carllee1991
 * 
 * #SubstringWithConcatenationOfAllWords
 * #LongestSubstringWithoutRepeatingCharacters
 * #LongestSubstringWithAtMostTwoDistinctCharacters
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c))	map.put(c, map.get(c) + 1);
			else	map.put(c, 1);
		}

		int left = 0, minLen = s.length() + 1, current = 0, minStart = 0;
		for (int right = 0; right < s.length(); ++right) {
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
				if (map.get(s.charAt(right)) >= 0)	++current;
				while (current == t.length()) {
					if (minLen > right - left + 1) {
						minLen = right - left + 1;
						minStart = left;
					}
					if (map.containsKey(s.charAt(left))) {
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if (map.get(s.charAt(left)) > 0)	--current;
					}
					++left;
				}
			}
		}

		return minLen>s.length()?"":s.substring(minStart, minStart+minLen);
	}
}
