package array;

import java.util.Arrays;

public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n){
		int i=0, j=0, k=0;
		int[] C = new int[m+n];
		while(i<m && j<n){
			if(A[i]<B[j])	C[k++] = A[i++];
			else if(A[i]>B[j]) C[k++] = B[j++];
			else{
				C[k++] = A[i++];
				C[k++] = B[j++];
			}
		}
		if(i<m)	while(i<m)	C[k++]=A[i++];
		if(j<n)	while(j<n)	C[k++]=B[j++];
		for(i=0; i<m+n; i++)	A[i] = C[i];
	}
	
	public static void main(String[] args){
		int[] A = new int[11];
		int[] B = {1,2,4,5,9};
		for(int i=0; i<6; i++)	A[i] = i;
		
		merge(A, 6, B, 5);
		System.out.print(Arrays.toString(A));
	}
}
