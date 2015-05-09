package tree.heap;

import java.util.Arrays;

public class TopK{
	// Binary Search: #MedianOfTwoSortedArrays
	public int findTopKInTwoUnsortedArray(int[] A, int[] B, int k){
		Arrays.sort(A);
		Arrays.sort(B);
		
		int l1 = 0, r1=A.length-1, l2=0, r2=B.length-1;
		return helper(A, B, l1, r1, l2, r2, k);
	}
	private int helper(int[] A, int[] B, int l1, int r1, int l2, int r2, int k){
		int lenA = r1-l1+1, lenB = r2-l2+1;
		if(lenA>lenB)	return helper(B, A, l2, r2, l1, r1, k);
		if(lenA==0)	return B[l2+k-1];
		if(k==1)	return Math.min(A[l1], B[l2]);
		
		int posA = Math.min(k/2, lenA), posB = k-posA;
		if(A[l1+posA-1]>B[l2+posB-1])
			return helper(A, B, l1, l1+posA-1, l2+posB, r2, posA);
		else return helper(A, B, l1+posA, r1, l2, l2+posB-1, posB);
	}
	
	// Binary Search: find TopK at A unsorted array
	public int findTopKUnsortetArray(int[] A, int k){
		helper(A, 0, A.length-1, k);
		return A[k-1];
	}
	private void helper(int[] A, int left, int right, int k){
		if(left<right){
			int point=partition(A, left, right);
			if(point==k-1)	return;
			else if(point<k-1)	helper(A, point+1, right, k);
			else helper(A, left, point-1, k);
		}
	}
	private int partition(int[] A, int left, int right){
		int i=left, j=right-1;
		while(i<j){
			while(i<j && A[i]<A[right]) i++;
			while(i<j && A[j]>A[right]) j--;
			if(i<j)	swap(A, i++, j--);
		}
		if(A[i]>A[right])	swap(A, i, right);
		return i;
	}
	private void swap(int[] A, int first, int second){
		int temp = A[first];
		A[first] = A[second];
		A[second] = temp;
	}
	
	public static void main(String[] args){
		int[] A = {3, 1, 7}, B = {4, 5, 6, 11, 9};
		System.out.println(new TopK().findTopKInTwoUnsortedArray(A, B, 5));
		System.out.println(new TopK().findTopKUnsortetArray(B, 5));
	}
}