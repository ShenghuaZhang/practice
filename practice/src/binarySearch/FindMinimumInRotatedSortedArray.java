package binarySearch;
/**
 * 153 154
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You may assume no duplicate exists in the array.
 * 
 */
public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] num) {
		int left = 0, right = num.length - 1, middle = (left + right) / 2;
		for (; left <= right; middle = (left + right) / 2) {
			if (num[left] <= num[right])	return num[left];
			else if(num[left]>num[middle])	right=middle;
			else	left=middle+1;
		}
		throw new IllegalArgumentException("Not find this min.");
	}
	
	//with duplicates
	public static int findMinWithDuplicates(int[] num){
		int left = 0, right = num.length - 1, middle = (left + right) / 2;
		for (; left<right && num[left]>=num[right]; middle = (left + right) / 2) {
			if(num[left]>num[middle])	right=middle;
			else if(num[left]<num[middle])	left=middle+1;
			else	left++;
		}
		return num[left];
	}
	
	public static void main(String[] args){
		int[] test0 = {3,1,2};
		System.out.println(findMin(test0));
		int[] test1 = {1,0,0,0,0,1,1,1,1};
		System.out.println(findMinWithDuplicates(test1));
	}
}
