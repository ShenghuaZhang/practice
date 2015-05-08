package string;

import java.util.Vector;

public class ValidPalindrome {
	public static boolean isPalindrome(String s){
		int start = 0, end = s.length()-1;
		while(start<end){
			while(start<end && !Character.isLetterOrDigit(s.charAt(start)))	start++;
			while(start<end && !Character.isLetterOrDigit(s.charAt(end)))	end--;
			if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
				start++;
				end--;
			}else return false;
		}
		
		return true;
	}
	public static void main(String[] args){
		Vector<Integer> vec = new Vector<>();
		vec.get(0);
		System.out.println(isPalindrome("!@&#!(@*^(*"));
	}
}
