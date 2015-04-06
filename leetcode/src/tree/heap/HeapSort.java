package tree.heap;

import java.util.Arrays;

public class HeapSort {
	public static void heapSort(int[] A){
		Heap heap = new Heap(A.length);
		for(int a:A)	heap.insert(a);
		int i=A.length-1;
		while(i>=0)	A[i--] = heap.remove().getValue();
	}
	
	public static void main(String[] args){
		int[] A = {3,4,45,2,5,2,31,7,23,5,0};
		heapSort(A);
		System.out.println(Arrays.toString(A));
	}
}
