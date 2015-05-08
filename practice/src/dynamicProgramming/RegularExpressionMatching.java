package dynamicProgramming;
/**
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a")  false
 * isMatch("aa","aa")  true
 * isMatch("aaa","aa")  false
 * isMatch("aa", "a*")  true
 * isMatch("aa", ".*")  true
 * isMatch("ab", ".*")  true
 * isMatch("aab", "c*a*b")  true
 * 
 * @author yili3
 * 
 * #WildcardMatching
 *
 */
public class RegularExpressionMatching {
	// brute force
	public boolean isMatchBruteForce(String s, String p){
		return helper(s, p, 0, 0);
	}
	private boolean helper(String s, String p, int i, int j){
		if(j==p.length())	return i==s.length();
		
		if(j==p.length()-1 || p.charAt(j+1)!='*'){
			if(i==s.length() || s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')
				return false;
			else return helper(s, p, i+1, j+1);
		}
		else if(i<s.length() && (p.charAt(j)=='.'||p.charAt(j)==s.charAt(i)))
			return helper(s, p, i, j+2) || helper(s, p, i+1, j);
		return helper(s, p, i, j+2);
	}
	// http://codeganker.blogspot.com/2014/02/regular-expression-matching-leetcode.html
	// dynamic programming
	public static boolean isMatchDP(String s, String p){
		if(s.length()==0 && p.length()==0)	return true;
		if(p.length()==0)	return false;
		
		boolean res[][] = new boolean[s.length()+1][p.length()+1];
		res[0][0] = true;
		for(int j=0; j<p.length(); j++){
			if(p.charAt(j)=='*'){
				if(j==0)	continue;
				if(j>=1 && res[0][j-1])	res[0][j+1] = true; // Example: a and c*a
				if(p.charAt(j-1)!='.'){
					for(int i=0; i<s.length(); i++){
						if(res[i+1][j]||res[i+1][j-1])
							res[i+1][j+1] = true;
						if(i>0 && j>0 && res[i][j+1] && s.charAt(i)==p.charAt(j-1))
							res[i+1][j+1] = true;
					}
				}else{
					int i= 0;
					while(j>0 && i<s.length() && !res[i+1][j-1] && !res[i+1][j])
						i++;
					for(;i<s.length(); i++)
						res[i+1][j+1] = true;
				}
			}else{
				for(int i=0; i<s.length(); i++){
					if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
						res[i+1][j+1] = res[i][j];
				}
			}
		}
		return res[s.length()][p.length()];
	}
	
	public static void main(String[] args){
		String s = "aaa", p = "ab*a";
		isMatchDP(s, p);
	}
}
