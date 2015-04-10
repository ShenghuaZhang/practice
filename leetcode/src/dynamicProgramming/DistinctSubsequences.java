package dynamicProgramming;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * @author yili3
 *
 */
public class DistinctSubsequences {
	public static int numDistinct(String S, String T){
		if(T.length()==0)	return 1;
		if(S.length()==0)	return 0;
		int[][] dp = new int[S.length()+1][T.length()+1];
		for(int i=0; i<T.length()+1; i++) dp[0][i] = 0;
		for(int i=0; i<S.length()+1; i++) dp[i][0] = 1;
		
		for(int i=0; i<S.length(); i++)
			for(int j=0; j<T.length(); j++)
				dp[i+1][j+1]=((T.charAt(j)==S.charAt(i))?dp[i][j]:0)+dp[i][j+1];
		
		return dp[S.length()][T.length()];
	}
	
	public static int numDistinctII(String S, String T){
		if(T.length()==0)	return 1;
		if(S.length()==0)	return 0;
		int[] dp = new int[T.length()+1];
		dp[0] = 1;
		for(int i=0; i<S.length(); i++)
			for(int j=0; j<T.length(); j++)
				dp[j+1] = ((S.charAt(i) == T.charAt(j))?dp[j]:0)+dp[j+1];
		
		return dp[T.length()];
	}
	
	public static void main(String[] args){
		String S = "cbcccbc", T = "bc";
		System.out.print(numDistinctII(S, T));
	}
}
