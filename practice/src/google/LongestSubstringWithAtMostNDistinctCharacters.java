package google;

import java.util.Arrays;

/**
 * 159
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * A much better solution for this problem after Google interview
 * Solve the problem that may happen when there is not enough memory
 * to store whole string
 * 
 * @author carllee1991
 * 
 * #LongestSubstringWithAtMostTwoDistinctCharacters
 *
 */
public class LongestSubstringWithAtMostNDistinctCharacters {
	public int lengthOfLongestSubstingTwoDistinct(String s, int n){
		int[] record = new int[256];
		Arrays.fill(record, -1);
		int start=0, numDistinct = 0, maxLen = 0;
		
		for(int cur=0; cur<s.length(); cur++){
			if(record[s.charAt(cur)]<0) numDistinct++;
			record[s.charAt(cur)] = cur;
			if(numDistinct > n){
				int min = cur;
				for(int i=0; i<record.length; i++)
					min = Math.min(min, record[i]==-1?min:record[i]);
				record[min] = -1;
				start = min+1;
			}
			maxLen = Math.max(cur-start+1,  maxLen);
		}
		return maxLen;
	}
}
