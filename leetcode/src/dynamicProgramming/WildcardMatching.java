package dynamicProgramming;
/**
 * TODO
 * https://leetcode.com/problems/wildcard-matching/
 * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

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
 */
public class WildcardMatching {
	public static boolean isMatch(String s, String p){
		return helper(s, p, 0, 0);
	}
	
	private static boolean helper(String s, String p, int i, int j){
		if(j==p.length())	return i==s.length();
		return false;
	}
	
	public static void main(String[] args){
		String s = "abefcdgiescdfimde", p = "ab*cd?i*de";
		System.out.print(isMatch(s, p));
	}
}
