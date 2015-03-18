package sort;

public class BubbleSort{
	public static void bubbleSort(int[] A){
		for(int i=0; i<A.length-1; i++)
			for(int j=0; j<A.length-1-i; j++)
				if(A[j]>A[j+1])	swap(A, j, j+1);
	}
	protected static void swap(int[] A, int first, int second){
		int temp = A[first];
		A[first] = A[second];
		A[second] = temp;
	}
}
