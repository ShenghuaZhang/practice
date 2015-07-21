package string;

/**
 * 28
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * @author jiakangze
 *
 */

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
        	return -1;
        }
        if (needle.length() == 0) {
        	return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        	for (int j = 0; j < needle.length(); j++) {
        		if (haystack.charAt(j+i) != needle.charAt(j)) {
        			break;
        		}
        		if (j == needle.length()-1) {
        			return i;
        		}
        	}
        }
        return -1;
    }
    
    public int strStr_yi(String haystack, String needle) {
        for (int i = 0;;i++) {
            for (int j = 0;;j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

}
