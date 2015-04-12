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
	public static boolean isMatchBruteForce(String s, String p){
		return helper(s, p, 0, 0);
	}
	private static boolean helper(String s, String p, int i, int j){
		if(j==p.length())	return i==s.length();
		
		if(j==p.length()-1 || p.charAt(j+1)!='*'){
			if(i==s.length() || s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')
				return false;
			else return helper(s, p, i+1, j+1);
		}
		
		while(i<s.length() && (p.charAt(j)=='.'||p.charAt(j)==s.charAt(i))){
			if(helper(s, p, i, j+2))	return true;// back tracking
			i++;
		}
		
		return helper(s, p, i, j+2);
	}
	
	public static void main(String[] args){
		String s = "baabbbaccbccacacc", p="c*..b*a*a.*a..*c";
		System.out.println(isMatchBruteForce(s, p));
	}
}
