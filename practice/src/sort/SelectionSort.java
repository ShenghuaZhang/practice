package sort;

public class SelectionSort {
	public void selectionSort(int[] A){
		for(int i=0; i<A.length-1; i++){
			int min = i;
			for(int j=i+1; j<A.length; j++)
				if(A[j]<A[min])	min=j;
			BubbleSort.swap(A, i, min);
		}
	}
}
