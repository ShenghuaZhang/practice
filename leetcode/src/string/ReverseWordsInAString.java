package string;

public class ReverseWordsInAString {
	public static String reverseWords(String s){
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() -1; i >= 0; i--){
			if (s.charAt(i) == ' ') j = i;
			else if (i == 0|| s.charAt(i-1) == ' '){
				if (reversed.length() != 0) reversed.append(' ');
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	public static void reverseWordsInPlace(char[] s){
		reverse(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++){
			if (j == s.length || s[j] == ' '){
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	private static void reverse(char[] s, int begin, int end){
		for (int i = 0; i < (end-begin)/2; i++){
			char temp = s[begin+i];
			s[begin+i] = s[end-i-1];
			s[end-i-1] = temp;
		}
	}
	
	public static void reverseWordsInPlace(String s){
		char[] c = s.toCharArray();
		reverseWordsInPlace(c);
		s = c.toString();
		System.out.println(c);
		System.out.println(s);
	}
	
	public static void main (String[] args){
		String s = "asjdflj sjdflksjf sdkljflsj";
		char[] c = s.toCharArray();
		reverseWordsInPlace(s);
		System.out.print(s + "\n");
		reverseWordsInPlace(c);
		System.out.print(c);
	} 
}
