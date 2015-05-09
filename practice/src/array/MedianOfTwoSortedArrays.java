package array;

/**
 * 4
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * 
 * @author carllee1991
 *
 *
 *	#TopK
 */
public class MedianOfTwoSortedArrays {
	/*
	 * Binary Search 
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
	    int len1 = nums1.length, len2 = nums2.length, k=(len1+len2)/2;
		if((len1+len2)%2==1)
			return helper(nums1, nums2, 0, len1-1, 0, len2-1, k+1);
		else return (helper(nums1, nums2, 0, len1-1, 0, len2-1, k)+
				helper(nums1, nums2, 0, len1-1, 0, len2-1, k+1))/2.0;
	}
	private int helper(int[] nums1, int[] nums2, int l1, int r1, int l2, int r2, int k){
		int len1 = r1-l1+1, len2 = r2-l2+1;
		if(len1>len2)	return helper(nums2, nums1, l2, r2, l1, r1, k);
		if(len1==0)	return nums2[l2+k-1];
		if(k==1)	return Math.min(nums1[l1], nums2[l2]);
		int posA = Math.min(k/2, len1), posB = k-posA;
		if(nums1[l1+posA-1] == nums2[posB+l2-1])
			return nums1[l1+posA-1];
		else if (nums1[posA+l1-1]<nums2[l2+posB-1])
			return helper(nums1, nums2, l1+posA, r1, l2, l2+posB-1, posB);
		else return helper(nums1, nums2, l1, l1+posA-1, l2+posB, r2, posA);
	}
}
