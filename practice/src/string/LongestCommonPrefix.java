package string;
/**
 * 14
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 * 
 * @author yili3
 *
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)  return "";
        
        int i=0;
        for(; i<strs[0].length(); i++){
        	char c = strs[0].charAt(i);
            for(String s:strs){
            	if(i>=s.length() || c!=s.charAt(i)){
            		if(i==0)	return "";
            		else return s.substring(0, i);
            	}
            }
        }
        return strs[0].substring(0, i);
    }
	
	public static void main(String[] args){
		String[] strs = {"aa", "ab"};
		System.out.print(longestCommonPrefix(strs));
	}
}
