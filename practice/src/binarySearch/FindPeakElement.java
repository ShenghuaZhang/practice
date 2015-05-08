package binarySearch;


/**
 * 162
 * https://leetcode.com/problems/find-peak-element/
 * 
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1],
 * find a peak element and return its index.
 * The array may contain multiple peaks,
 * in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 *
 * Your solution should be in logarithmic complexity.
 * 
 * @author carllee1991
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int left = 0, right = num.length-1;
		
		while(left<right){
			int middle = (left+right)/2;
			if(num[middle]>num[middle+1])	right=middle;
			else  left=middle+1;
		}
		
		return left;
    }
}
