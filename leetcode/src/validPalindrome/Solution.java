package validPalindrome;

public class Solution {
	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() -1;
		while(i < j){
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args){
		String[] s = {"A man, a plan, a canal: Panama", "race a car", "asdfggfdas" , "asdfgfdsa"};
		for (int i = 0; i < s.length; i++){
			if (isPalindrome(s[i]))	System.out.print("\n" + i + ": " + s[i] + ", It is palindrome.");
			else System.out.print("\n" + i + ": " + s[i] + ", It is not palindrome.");
		}
	}
}
