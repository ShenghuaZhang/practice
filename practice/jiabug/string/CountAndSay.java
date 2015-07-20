package string;

/**
 * 38
 * https://leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author kajia
 *
 */

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(6));

	}
	
    public static String countAndSay(int n) {
    	if (n <= 0) {
    		return null;
    	}
    	StringBuilder res = new StringBuilder("1");
    	if (n == 1) {
    		return res.toString();
    	}
    	
        while (n > 1) {
        	int count = 1;
        	StringBuilder temp = new StringBuilder();
        	int i = 1;
        	char pre = res.charAt(0);
        	while (i <= res.length()) {
        		if (i < res.length() && res.charAt(i) == pre) {
        			count++;
        			i++;
        		} else {
        			temp.append(count);
        			temp.append(pre);
        			if (i < res.length()) {
        				pre = res.charAt(i);
        			}
        			count = 1;
        			i++;
        		}
        	}
        	res = temp;
        	n--;
        }
        return res.toString();
    }

}
