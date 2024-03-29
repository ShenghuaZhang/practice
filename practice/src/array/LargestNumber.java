package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 179
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
	public String largestNumber(int[] nums){
		if(nums==null)	return null;
		
		List<Integer> list = new ArrayList<>();
		for(int n:nums)	list.add(n);
		
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
}
