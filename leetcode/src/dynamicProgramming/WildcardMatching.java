package dynamicProgramming;
/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * boolean isNumeric(String s){
 * 		return s.matches("[-+]?\\d*\\.?\\d+");}
 * 
 * Some examples:
 * isMatch("aa","a")  false
 * isMatch("aa","aa")  true
 * isMatch("aaa","aa")  false
 * isMatch("aa", "*")  true
 * isMatch("aa", "a*")  true
 * isMatch("ab", "?*")  true
 * isMatch("aab", "c*a*b")  false
 * 
 * @author yili3
 * 
 * #RegularExpressionMatching
 *
 */
public class WildcardMatching {
	// dynamic programming using only 1D array
	// http://codeganker.blogspot.com/2014/03/wildcard-matching-leetcode.html
	public static boolean isMatchDPBest(String s, String p){
		if(p.length()==0)	return s.length()==0;
		
		boolean[] ret = new boolean[s.length()+1];
		ret[0]=true;
		for(int j=0; j<p.length(); j++){
			if(p.charAt(j)=='*'){
				int i=0;
				while(i<=s.length() && !ret[i])	i++;
				for(; i<=s.length(); i++)	ret[i] = true;
			}else{
				for(int i=s.length()-1;i>=0;i--)
                    ret[i+1] = ret[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));
			}
			ret[0] = ret[0] && p.charAt(j)=='*';
		}
		
		return ret[s.length()];
	}
	
	//brute force
	public static boolean isMatchBF(String s, String p){
		return helper(s, p, 0, 0);
	}
	private static boolean helper(String s, String p, int i, int j){
		if(j==p.length())	 return i==s.length();
		if(i==s.length()){
			if(p.charAt(j)!='*')    return false;
			else return helper(s, p, i, j+1);
		}
		if(p.charAt(j)=='*')
			return helper(s, p, i, j+1) || helper(s, p, i+1, j);
		else if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
			return helper(s, p, i+1, j+1);
		else return false;
	}
	
	// dynamic programming
	public static boolean isMatchDP(String s, String p){
		if(s.length()==0 && p.length()==0)	return true;
		if(p.length()==0)	return false;
		
		boolean[][] ret = new boolean[s.length()+1][p.length()+1];
		ret[0][0]=true;
		for(int j=0; j<p.length(); j++){
			if(p.charAt(j)=='*'){
				int i=0;
				while(j>0 && i<s.length() && !ret[i+1][j])	i++;
				for(; i<s.length(); i++)	ret[i+1][j+1] = true;
			}else{
				for(int i=0; i<s.length(); i++)
					if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='?')
						ret[i+1][j+1] = ret[i][j];
			}
			ret[0][j+1] = ret[0][j] && p.charAt(j)=='*';
		}
		
		return ret[s.length()][p.length()];
	}
	
	public static void main(String[] args){
		String s = "b", p = "?*?";
		System.out.print(isMatchDP(s, p));
	}
}
