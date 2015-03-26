package sort;

import java.util.Arrays;

public class Partition {
	public static int partition(int[] A, int left, int right){
		int n= right--;
		while(left<right){
			while(A[left]<A[n])	left++;
			while(left<right && A[right]>=A[n])	right--;
			if(left<right) BubbleSort.swap(A, left++, right--);
		}
		BubbleSort.swap(A, left, n);
		return left;
	}
	
	public static int partitionMine(int[] A, int left, int right, int n){
		while(left<right){
			while(A[left]<n)	left++;
			while(left<right && A[right]>=n)	right--;
			if(left<right)	BubbleSort.swap(A, left++, right--);
		}
		return left;
	}
	public static void main(String[] args){
		int[] A = {28,43,24,5,12,34,23,23};
		partitionMine(A, 0, 7, 24);
		System.out.println(Arrays.toString(A));
	}
}
