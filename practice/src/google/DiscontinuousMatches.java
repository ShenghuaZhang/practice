package google;
/**
 * http://www.careercup.com/question?id=5757597581836288
 * 
 * Question: Given two strings, find number of discontinuous matches.
 * Example: cat, catapult
 * Output: 3   => CATapult, CatApulT, CAtapulT
 * 
 * @author yili3
 * 
 * #DistinctSubsequences
 */
public class DiscontinuousMatches {
	static int getDiscontinuousMatches(String pattern, String text){
		int[][] dp = new int[pattern.length()+1][1+text.length()];
		for(int i=0; i<pattern.length()+1; i++)	dp[i][0] = 0;
		for(int i=0; i<text.length()+1; i++)	dp[0][i] = 1;
		
		for(int i=0; i<pattern.length(); i++){
			for(int j=0; j<text.length(); j++){
				if(pattern.charAt(i)==text.charAt(j))
					dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
				else
					dp[i+1][j+1] = dp[i+1][j]; 
			}
		}
		
		return dp[pattern.length()][text.length()];
	}
	public static void main(String[] args){
		String pattern = "cat", text="catapult";
		System.out.print(getDiscontinuousMatches(pattern, text));
	}
}
