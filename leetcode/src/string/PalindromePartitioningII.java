package string;
/**
 * 132
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * Given a string s,
 * partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author yili3
 * 
 * #PalindromePartitioning #WordBreak #WordBreakII
 *
 */
public class PalindromePartitioningII {
	public int minCut(String s){
		boolean[][] palinDict = findAllPalin(s);
		
		int[] res = new int[s.length()];
		for(int i=0; i<s.length(); i++){
			res[i] = i;
			for(int j=0; j<=i; j++){
				if(palinDict[j][i])
					res[i] = Math.min(res[i], res[j]+1);
			}
		}
		return res[s.length()-1];
	}
	private boolean[][] findAllPalin(String s){
		boolean[][] palinDict = new boolean[s.length()][s.length()];
		
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<=i; j++){
				if(s.charAt(i)==s.charAt(j)&&(i-j<2||palinDict[j+1][i-1]))
					palinDict[j][i] = true;
			}
		}
		return palinDict;
	}
}
