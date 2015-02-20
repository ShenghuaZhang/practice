package binarySearch;

public class SearchInsertPosition {
	public static int searchInsert(int[] A, int target){
		if (A==null || A.length == 0)	return 0;
		
		int left = 0, right = A.length-1, mid=(left+right)/2;
		for(; left<=right; mid=(left+right)/2){
			if (A[mid]>target)	right = mid-1;
			else if (A[mid]<target)	left = mid+1;
			else return mid;
		}
		return left;
	}
}
