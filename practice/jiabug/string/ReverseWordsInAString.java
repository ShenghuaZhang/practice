package string;

/**
 * 151
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * @author kajia
 *
 */

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords_yi("   a   b "));

	}
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        
        s = s.trim();
        
        StringBuilder res = new StringBuilder();
        
        int runner = 0;
        
        while (runner < s.length()) {
        	StringBuilder temp = new StringBuilder();
        	while (runner < s.length() && s.charAt(runner) != ' ') {
        		temp.append(s.charAt(runner));
        		runner++;
        	} 
        	while (runner < s.length() && s.charAt(runner) == ' ') {
        		runner++;
        	}
        	res.insert(0, temp);
        	res.insert(0, ' ');
        }
        return res.toString().trim();
    }
    
    
    //recursive method
    public static String reverseWords_ganker(String s) {
    	s = s.trim();
    	return helper(s,0).toString();
    }
    
    private static StringBuilder helper(String s, int index) {
    	if (index == s.length()) {
    		return new StringBuilder();
    	}
    	int cur = index;
    	StringBuilder res = new StringBuilder();
    	while(index < s.length() && s.charAt(index) != ' ') {
    		res.append(s.charAt(index++));
    	}
    	while (index < s.length() && s.charAt(index) == ' ') {
    		index++;
    	}
    	
    	if(cur == 0) {
    		return helper(s, index).append(res);
    	}
    	return helper(s, index).append(res).append(' ');
    }
    
    public static String reverseWords_ganker2(String s) {
    	if (s == null) {
    		return null;
    	}
    	s = s.trim();
    	
    	if (s.length() == 0) {
    		return "";
    	}
    	StringBuilder res = new StringBuilder();
    	
    	for (int i = s.length() - 1; i >= 0; i--) {
    		if (i != s.length()-1 && s.charAt(i) == ' ' && s.charAt(i) == s.charAt(i+1)) {//already trim, the last one must not be blank space
    			continue;
    		}
    		res.append(s.charAt(i));
    	}
    	
    	int left = 0;
    	int right = 0;
    	System.out.println(res);
    	while (right < res.length()) {
    		while (right < res.length() && res.charAt(right) != ' ') {
    			right++;
    		}
    		int next = right + 1;
    		right--;
    		while (left < right) {
    			char temp = res.charAt(right);
    			res.setCharAt(right--, res.charAt(left));
    			res.setCharAt(left++, temp);
    		}
    		left = next;
    		right = next;
    	}
    	return res.toString();
    }
    
    
    //Could you do it in-place without allocating extra space?
    //we do not consider blank space through this method
    public static String reverseWords_yi(String s) {
    	char[] c = s.toCharArray();
    	reverseWords(c);
    	return new String(c);
    }
    public static void reverseWords(char[] c) {
    	if (c == null || c.length == 0) {
    		return;
    	}
    	reverse(c, 0, c.length-1);
    	for (int i = 0, pre = 0; i <= c.length; i++) {
    		if (i == c.length || c[i] == ' ') {
    			reverse(c, pre, i-1);
    			pre = i+1;
    		}
    	}
    }
    public static void reverse(char[] c, int start, int end) {
    	for (; start < end; start++, end--) {
    		char temp = c[start];
    		c[start] = c[end];
    		c[end] = temp;
    	}
    }
    
}
