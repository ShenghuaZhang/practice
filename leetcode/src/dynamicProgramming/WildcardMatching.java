package dynamicProgramming;
/**
 * 44
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
	// dynamic programming
	public boolean isMatch(String s, String p){
        if(p.length()==0)	return s.length()==0;
		boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        
		for(int pIndex=0; pIndex<p.length(); pIndex++){
			if(p.charAt(pIndex)=='*'){
				int sIndex=0;
				while(pIndex>0 && sIndex<s.length() && !match[sIndex+1][pIndex])	sIndex++;
				for(; sIndex<s.length(); sIndex++)	match[sIndex+1][pIndex+1] = true;
			}else{
			    for(int sIndex=0; sIndex<s.length(); sIndex++)
					if(s.charAt(sIndex)==p.charAt(pIndex)||p.charAt(pIndex)=='?')
						match[sIndex+1][pIndex+1]=match[sIndex][pIndex];
			}
			match[0][pIndex+1] = match[0][pIndex] && p.charAt(pIndex)=='*';
		}
        return match[s.length()][p.length()];
	}
	
	// dynamic programming using only 1D array
	// http://codeganker.blogspot.com/2014/03/wildcard-matching-leetcode.html
	public boolean isMatchDPBest(String s, String p){
		if(p.length()==0)	return s.length()==0;
		boolean[] match = new boolean[s.length()+1];
        match[0] = true;
        
		for(int pIndex=0; pIndex<p.length(); pIndex++){
			if(p.charAt(pIndex)=='*'){
				int sIndex=0;
				while(sIndex<=s.length() && !match[sIndex])	sIndex++;
				for(; sIndex<=s.length(); sIndex++)	match[sIndex] = true;
			}else{
				for(int sIndex=s.length()-1; sIndex>=0; sIndex--)
					if(s.charAt(sIndex)==p.charAt(pIndex) || p.charAt(pIndex)=='?')
						match[sIndex+1] = match[sIndex];
					else match[sIndex+1] = false;
			}
			match[0] = match[0] && p.charAt(pIndex)=='*';
		}

        return match[s.length()];
	}
	
	//brute force
	public boolean isMatchBF(String s, String p){
		return helper(s, p, 0, 0);
	}
	private boolean helper(String s, String p, int i, int j){
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
}
