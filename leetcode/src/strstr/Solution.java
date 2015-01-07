package strstr;

public class Solution {
	public static int strstr(String haystack, String needle){
		for (int i = 0; ;i++){
			for (int j = 0; ;j++){
				if (j == needle.length()) return i;
				if (i + j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i+j)) break;
			}
		}
	}
	
	public static void main(String[] args){
		String haystack = "asdjflsajfljfkla", needle = "asdjfl";
		if (strstr(haystack, needle) >= 0)	System.out.print("TRUE");
		else System.out.print("FALSE");
	}
}
