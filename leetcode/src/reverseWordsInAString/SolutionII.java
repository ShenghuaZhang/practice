package reverseWordsInAString;

public class SolutionII {
	public static void reverseWords(char[] s){
		reverse(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++){
			if (j == s.length || s[j] == ' '){
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}
	
	public static void reverseWords(String s){
		char[] c = s.toCharArray();
		reverseWords(c);
		s = c.toString();
	}
	
	private static void reverse(char[] s, int begin, int end){
		for (int i = 0; i < (end-begin)/2; i++){
			char temp = s[begin+i];
			s[begin+i] = s[end-i-1];
			s[end-i-1] = temp;
		}
	}
	
	public static void main (String[] args){
		String s = "asjdflj sjdflksjf sdkljflsj";
		char[] c = s.toCharArray();
		reverseWords(s);
		reverseWords(c);
		System.out.print(s + "\n");
		System.out.print(c);
	} 
}
