package string;
/**
 * 151 186
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * 
 * Given an input string, reverse the string word by word.
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing 
 * spaces and the words are always separated by a single space.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Could you do it in-place without allocating extra space?
 * 
 * @author yili3
 * 
 * #RotatedArray
 *
 */
public class ReverseWordsInAString {
	public static void reverseWords(char[] s) {
        if(s==null || s.length==0)  return;
        reverse(s, 0, s.length-1);
        for(int i=0, temp=0; i<=s.length; i++){
            if(i==s.length||s[i]==' '){
                reverse(s, temp, i-1);
                temp = i+1;
            }
        }
    }
    private static void reverse(char[] s, int start, int end){
        for(; start<end; start++, end--){
            char temp = s[start];
            s[start]= s[end];
            s[end] = temp;
        }
    }
	
    public static void reverseWordsString(String s){
    	char[] c = s.toCharArray();
    	reverseWords(c);
    	s=new String(c);
    }
	public static void main (String[] args){
		String s = "asjdflj sjdflksjf sdkljflsj";
		char[] c = s.toCharArray();
		System.out.print(s + "\n");
		reverseWords(c);
		System.out.print(c);
	} 
}
