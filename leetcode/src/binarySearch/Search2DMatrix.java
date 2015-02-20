package binarySearch;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target){
		int up = 0, down=matrix.length-1, middle = (up+down)/2;
		for(;up<=down; middle = (up+down)/2){
			if (matrix[middle][0] > target) down = middle-1;
			else if (matrix[middle][0] < target)	up = middle + 1;
			else return true;
		}
		if (down < 0)	return false;
		int left = 0, right = matrix[0].length-1;
		for(middle=(left+right)/2; left<=right; middle=(left+right)/2){
			if (matrix[down][middle] > target)	right = middle-1;
			else if(matrix[down][middle] < target)	left = middle+1;
			else return true;
		}
		return false;
	}
}
