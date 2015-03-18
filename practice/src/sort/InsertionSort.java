package sort;

public class InsertionSort {
	public static void insertionSort(int[] A){
		for(int i=1; i<A.length; i++)
			for(int j=i; j>0 && A[j]<A[j-1]; j--)
				BubbleSort.swap(A, j, j-1);
	}
}
