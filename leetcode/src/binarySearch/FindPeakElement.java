package binarySearch;
/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Your solution should be in logarithmic complexity.
 * 
 * @author carllee1991
 *
 */
public class FindPeakElement {
	public static int findPeakElement(int[] num){
		int left = 0, right = num.length-1;
		
		while(left<right){
			int middle = (left+right)/2;
			if(num[middle]>num[middle+1])	right=middle;
			else  left=middle;
		}
		
		return left;
	}
}
