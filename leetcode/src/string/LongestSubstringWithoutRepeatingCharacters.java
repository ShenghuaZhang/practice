package string;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s){
		int[] exist = new int[256];
		Arrays.fill(exist, -1);
		int maxLen = 0, start=0;
		
		for(int cur=0; cur<s.length(); cur++){
			if (exist[s.charAt(cur)] >= start)
				start = exist[s.charAt(cur)]+1;
			exist[s.charAt(cur)] = cur;
			maxLen = Math.max(cur-start+1, maxLen);
		}
		return maxLen;
	}
}
