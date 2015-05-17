package string;
/**
 * 159
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * 
 * Given a string, find the length of the longest substring T that
 * contains at most 2 distinct characters.
 * 
 * For example, Given s = eceba,
 * T is "ece" which its length is 3.
 * 
 * @author yili3
 * 
 * Better solution from Google: #LongestSubstringWithAtMostNDistinctCharacters
 * #LongestSubstringWithoutRepeatingCharacters
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	/* Two pointer:
	 * #TwoSumII #ContainerWithMostWater
	 * #ContainerWithMostWater
	 * #LongestSubstringWithoutRepeatingCharacters
	 * #MaximumRangeNumber
	 * */
	public int lengthOfLongestSubstingTwoDistinct(String s){
		int[] count = new int[256];
		int start=0, numDistinct = 0, maxLen = 0;
		for(int cur=0; cur<s.length(); cur++){
			if(count[s.charAt(cur)] == 0) numDistinct++;
			count[s.charAt(cur)]++;
			while(numDistinct > 2){
				count[s.charAt(start)] --;
				if(count[s.charAt(start)] == 0) numDistinct--;
				start++;
			}
			maxLen = Math.max(cur-start+1,  maxLen);
		}
		return maxLen;
	}
}
