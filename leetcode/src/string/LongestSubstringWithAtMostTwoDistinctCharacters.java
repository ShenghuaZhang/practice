package string;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	// totally did not understand this algorithm
	public static int lengthOfLongestSubstingTwoDistinct(String s){
		int i=0, j=-1, maxLen=0;
		for(int k=1; k<s.length(); k++){
			if (s.charAt(k) == s.charAt(k-1))	continue;
			if (j>=0 && s.charAt(j) != s.charAt(k)){
				maxLen = Math.max(k-i, maxLen);
				i = j+1;
			}
			j = k-1;
		}
		return Math.max(s.length()-i, maxLen);
	}
	
	// this one much easier to understand
	public static int lengthOfLongestSubstingTwoDistinctII(String s){
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
	
	public static void main(String[] args){
		System.out.print(lengthOfLongestSubstingTwoDistinct("aabbacccaa"));
	}
}
