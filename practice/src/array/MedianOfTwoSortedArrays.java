package array;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		if((nums1.length+nums2.length)%2==1)
			return helper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, (nums1.length+nums2.length)/2+1);
		else return (helper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, (nums1.length+nums2.length)/2)+
				helper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, (nums1.length+nums2.length)/2+1))/2.0;
	}
	private int helper(int[] A, int[] B, int i, int i2, int j, int j2, int k){
		int m = i2-i+1, n = j2-j+1;
		if(m>n)	return helper(B, A, j, j2, i, i2, k);
		if(m==0)	return B[j+k-1];
		if(k==1)	return Math.min(A[i], B[j]);
		int posA = Math.min(k/2, m);
		int posB = k-posA;
		if(A[i+posA-1] == B[posB+j-1])
			return A[i+posA-1];
		else if (A[posA+i-1]<B[j+posB-1])
			return helper(A, B, i+posA, i2, j, j+posB-1, k-posA);
		else return helper(A, B, i, i+posA-1, j+posB, j2, k-posB);
	}
}
