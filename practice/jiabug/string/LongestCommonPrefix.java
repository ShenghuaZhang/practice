package string;

/**
 * 14
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author jiakangze
 *
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";//in here, we need return "" not null
        }
        
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < strs[0].length(); j++) {
        	char ch = strs[0].charAt(j);
        	for (int k = 0; k < strs.length; k++) {
        		if (j < strs[k].length() && strs[k].charAt(j) == ch) {
        			continue;
        		} else {
        			return res.toString();
        		}
        	}
        	res.append(ch);
        }
        
        return res.toString();
    }
    
    public static String longestCommonPrefix_yi(String[] strs) {
    	if (strs == null || strs.length == 0) {
        	return "";
        }
    	int i = 0;
    	for (;i < strs[0].length(); i++) {
    		char ch = strs[0].charAt(i);
    		for (int j = 0; j < strs.length; j++) {
    			if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
    				if (i == 0) {
    					return "";
    				} else {
    					return strs[0].substring(0, i);
    				}
    			}
    		}
    	}
    	return strs[0].substring(0, i);
    }

}
