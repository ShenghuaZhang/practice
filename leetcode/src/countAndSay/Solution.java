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
		 StringBuilder ret = new StringBuilder();
		 int count = 0;
		 
		 if (n < 1) return ret.toString();
		 
		 while(count < n){
			 count++;
		 }
		 return ret.toString();
	 }
	 
	 public static void main(String[] args){
		 System.out.print(countAndSay(23));
	 }
}