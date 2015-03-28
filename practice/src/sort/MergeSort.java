package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	protected static Integer[] merge(int[] A, int[] B){
		int length1 = 0, length2 = 0;
		List<Integer> list = new ArrayList<>();
		
		while(length1<A.length && length2<B.length){
			if(A[length1]>B[length2])	list.add(B[length2++]);
			else list.add(A[length1++]);
		}
		
		while(length1<A.length)	list.add(A[length1++]);
		while(length2<B.length)	list.add(B[length2++]);
		
		Integer[] C = list.toArray(new Integer[list.size()]);
		System.out.println(Arrays.toString(C));
		return C;
	}
	
	public static void main(String[] args){
		int[] A = {12,3};
		int[] B = {11,20,51};
		QuickSort.quickSort(A, B);
		merge(A, B);
	}
}
