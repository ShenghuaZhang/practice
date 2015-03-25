package sort;

import java.util.Arrays;

public class Partition {
	public static void partition(int[] A, int left, int right, int n){
		int i=left-1, j=right;
		while(i<j){
			while(A[i]<n)	i++;
			while(A[j]>=n)	j--;
			if(i<j)	BubbleSort.swap(A, i++, j--);
		}
	}
	public static void main(String[] args){
		int[] A = {28,43,24,5,12,34,23,23};
		partition(A, 1,5,24);
		System.out.println(Arrays.toString(A));
	}
}
