package sort;

public class QuickSort {
	public static void quickSort(int[] A){
		helperI(A, 0, A.length-1);
	}
	
	static void helperI(int[] A, int left, int right){
		if(left>=right)	return;
		int partition = partition(A, left, right);
		helperI(A, left, partition-1);
		helperI(A, partition+1, right);
	}
	static int partition(int[] A, int left, int right){
		int n= right--;
		while(left<right){
			while(A[left]<A[n])	left++;
			while(left<right && A[right]>=A[n])	right--;
			if(left<right) BubbleSort.swap(A, left++, right--);
		}
		if(A[left]>A[n])	BubbleSort.swap(A, left, n);
		return left;
	}
	
	
	static void helperII(int[] A, int left, int right){
		if(left-right<10)	insertionSort(A, left, right);
		else{
			int median = medianOfThree(A, left, right);
			int partition = partitionMine(A, left, right, median);
			helperII(A, left, partition-1);
			helperII(A, partition+1, right);
		}
	}
	static void insertionSort(int[] A, int left, int right){
		if(left>=right)	return;
		for(int i=left+1; i<=right; i++)
			for(int j=i; j>0 && A[j]<A[j-1]; j--)
				BubbleSort.swap(A, j, j-1);
	}
	static int medianOfThree(int[] A, int left, int right){
		int median = (left+right)/2;
		if(A[left]>A[median])	BubbleSort.swap(A, left, median);
		if(A[median]>A[right])	BubbleSort.swap(A, median, right);
		if(A[left]>A[right])	BubbleSort.swap(A, left, right);
		return A[median];
	}
	static int partitionMine(int[] A, int left, int right, int n){
		while(left<right){
			while(A[left]<n)	left++;
			while(left<right && A[right]>=n)	right--;
			if(left<right)	BubbleSort.swap(A, left++, right--);
		}
		return left;
	}
}
