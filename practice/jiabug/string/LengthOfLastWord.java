package string;

/**
 * 58
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * @author jiakangze
 *
 */

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("a "));

	}
	
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        s = s.trim();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == ' ') {
        		res = 0;
        	} else {
        		res++;
        	}
        }
        return res;
    }
    
    public static int lengthOfLastWord_yi(String s) {
    	int res = 0;
    	int pre = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == ' ') {
    			if(res != 0) {//if we do not add this statement , when the input is "b   a    ", this will be wrong
    				pre = res;
    			}
    			res = 0;
    		} else {
    			res++;
    		}
    	}
    	return res == 0? pre:res;
    }

}
