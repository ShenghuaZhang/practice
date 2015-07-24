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
 * KMP method!!!!
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
    
    public int strStr_KMP(String haystack, String needle) {
    	if (needle.length() > haystack.length()) {
        	return -1;
        }
        if (needle.length() == 0) {
        	return 0;
        }
        //get the array of next
    	int[] next = new int[needle.length()];
    	next[0] = -1;
    	int j = 0;
    	int k = -1;
    	
    	while (j < haystack.length() - 1) {
    		if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
    			k++;
    			j++;
    			if(needle.charAt(k) == needle.charAt(j)) {
    				next[j] = next[k];
    			} else {
    				next[j] = k;
    			}
    		} else {
    			k = next[k];
    		}
    	}
    	//begin searching
    	int h = 0;
    	int n = 0;
    	while (h < haystack.length() && n < needle.length()) {
    		if (n == -1 || haystack.charAt(h) == needle.charAt(n)) {
    			n++;
    			h++;
    		} else {
    			n = next[n];
    		}
    	}
    	if (n == needle.length()) {
    		return h - n;
    	} else {
    		return -1;
    	}
    }

}
