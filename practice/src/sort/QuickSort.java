package sort;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] A, int[] B){
		helperI(A, 0, A.length-1);
		helperII(B, 0, B.length-1);
	}
	
	protected static void helperI(int[] A, int left, int right){
		if(left>=right)	return;
		int partition = Partition.partition(A, left, right);
		helperI(A, left, partition-1);
		helperI(A, partition+1, right);
	}
	
	protected static void helperII(int[] A, int left, int right){
		if(left-right<10)	insertionSort(A, left, right);
		else{
			int median = medianOfThree(A, left, right);
			int partition = Partition.partitionMine(A, left, right, median);
			helperII(A, left, partition-1);
			helperII(A, partition+1, right);
		}
	}
	private static int medianOfThree(int[] A, int left, int right){
		int median = (left+right)/2;
		if(A[left]>A[median])	BubbleSort.swap(A, left, median);
		if(A[median]>A[right])	BubbleSort.swap(A, median, right);
		if(A[left]>A[right])	BubbleSort.swap(A, left, right);
		return A[median];
	}
	
	public static void insertionSort(int[] A, int left, int right){
		if(left>=right)	return;
		for(int i=left+1; i<=right; i++)
			for(int j=i; j>0 && A[j]<A[j-1]; j--)
				BubbleSort.swap(A, j, j-1);
	}
	
	public static void main(String[] args){
		int[] A = {12,21,5,43,3,2,3,4,2,1,13,5,4,24};
		int[] B = {11,20,51,431,31,21,31,41,21,11,131,51,41
				,124,12,21,5,43,3,2,3,4,2,1,13,5,4,24};
		
		quickSort(A, B);
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
	}
}
