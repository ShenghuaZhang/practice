package countAndSay;

//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//Note: The sequence of integers will be represented as a string.
//package countAndSay;


public class Solution {
	 private static String countAndSay(int n) {
		 String curRes = "1";
		 if (n < 1) return "";
		 if (n == 1) return curRes;
		 while(n>1){
			 StringBuilder ret = new StringBuilder();
			 int count = 1;
			 for(int j = 1; j<curRes.length(); j++){
				 if (curRes.charAt(j) == curRes.charAt(j-1))	count ++;
				 else {
					 ret.append(count);
					 ret.append(curRes.charAt(j-1));
					 count = 1;
				 }
			 }
			 ret.append(count);
			 ret.append(curRes.charAt(curRes.length()-1));
			 curRes = ret.toString();
			 n--;
		 }
		 return curRes;
	 }
	 
	 public static void main(String[] args){
		 System.out.print(countAndSay(7));
	 }
}