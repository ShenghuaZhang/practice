package sort;

import java.util.Arrays;

public class MergeSort {
	static void mergeSort(int[] A){
		mergeSort(A, 0, A.length-1);
	}
	// copy: N*logN*2
	static void mergeSort(int[] A, int left, int right){
		if(left>=right)	return;
		int middle = (left+right)/2;
		mergeSort(A, left, middle);
		mergeSort(A, middle+1, right);
		merge(A, left, right);
	}
	// compare: best N/2	worst N-1
	static void merge(int[] A, int left, int right){
		int[] C = new int[right-left+1];
		int first=left, second = (left+right)/2+1, i=0;
		
		while(first<=(left+right)/2 && second<=right){
			if(A[first]<A[second])	C[i++] = A[first++];
			else C[i++] = A[second++];
		}
		while(first<=(left+right)/2)	C[i++] = A[first++];
		while(second<=right)	C[i++] = A[second++];
		
		for(i=0; i<C.length; i++)	A[left+i] = C[i];
	}
	
	public static void main(String[] args){
		int[] A = {11,20,51,431,31,21,31,41,21,11,131,51,41
			,124,12,21,5,43,3,2,3,4,2,1,13,5,4,24};
		mergeSort(A);
		System.out.println(Arrays.toString(A));
	}
}
