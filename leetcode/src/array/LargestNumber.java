package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-number/
 * 
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed
 * number is 9534330.
 * Note: The result may be very large, so you need to return
 * a string instead of an integer.
 * 
 * @author yili3
 *
 */
public class LargestNumber {
	public String largestNumber(int[] num){
		if(num==null)	return null;
		
		List<Integer> list = new ArrayList<>();
		for(int n:num)	list.add(n);
		
		Collections.sort(list, new Comparator<Integer>(){
			public int compare(Integer first, Integer second){
				String s1 = "" + first + second;
				String s2 = "" + second + first;
				return s2.compareTo(s1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int n:list)	sb.append(n);
		
		if(sb.charAt(0) == '0')	return "0";
		return sb.toString();
	}
	
	public static class Card implements Comparable<Card> {
		int val;

		public Card(int val) {
			super();
			this.val = val;
		}
		
		public String toString() {
			return "" + val;
		}

		public int compareTo(Card c) {
			return c.val - this.val;
		}
	}
	
	public static void main(String[] strs) {
		List<Card> cards = new ArrayList<>(Arrays.asList(new Card(11), new Card(2)));

		Collections.sort(cards);

		for (Card card : cards)
			System.out.println(card.toString());

	}
}
