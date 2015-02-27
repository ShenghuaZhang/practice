package string;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	// totally did not understand algorithm
	public static int lengthOfLongestSubstingTwoDistinct(String s){
		int i=0, j=-1, maxLen=0;
		for(int k=1; k<s.length(); k++){
			if (s.charAt(k) == s.charAt(k-1))	continue;
			if (j>=0 && s.charAt(j) != s.charAt(k)){
				maxLen = Math.max(k-i, maxLen);
				i = j+1;
			}
			j = k-i;
		}
		return Math.max(s.length()-i, maxLen);
	}
	// this one much better
	public static int lengthOfLongestSubstingTwoDistinctII(String s){
		int[] count = new int[256];
		int i=0, numDistinct = 0, maxLen = 0;
		for(int j=0; j<s.length(); j++){
			if(count[s.charAt(j)] == 0) numDistinct++;
			count[s.charAt(j)]++;
			while(numDistinct > 2){
				count[s.charAt(i)] --;
				if(count[s.charAt(i)] == 0) numDistinct--;
				i++;
			}
			maxLen = Math.max(j-i+1,  maxLen);
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		System.out.print(lengthOfLongestSubstingTwoDistinctII("abaac"));
	}
}
