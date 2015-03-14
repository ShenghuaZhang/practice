package binarySearch;

public class SearchForARange {
	public int[] searchRange(int[] A, int target){
		int[] res = new int[]{-1,-1};
		if (A == null || A.length == 0)	return res;
		
		int left = 0, right = A.length-1, mid = (left+right)/2;
		for(;left<=right; mid=(left+right)/2){
			if (A[mid] > target)	right = mid -1;
			else if (A[mid] < target)	left = mid + 1;
			else {
				for(mid--; mid>=0&&A[mid]==target; mid--);
				res[0] = mid+1;
				for(mid++; mid<A.length&&A[mid]==target; mid++);
				res[1] = mid-1;
				return res;
			}
		}
		return res;
	}
}
