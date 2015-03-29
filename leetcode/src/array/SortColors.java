package array;

/**
 * https://leetcode.com/problems/sort-colors/
 * TODO: 03/28/2015
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue. Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 * 
 * @author yili3
 *
 */
public class SortColors {
	public void sortColors(int[] A){
		if(A==null || A.length==0)	return;
		for(int i=0, zero=0, one=0; i<A.length; i++){
			if(A[i]==0){
				A[i] = 2;
				A[one++] = 1;
				A[zero++] = 0;
			}else if(A[i] == 1){
				A[i] =2;
				A[one++] = 1;
			}
		}
	}
}
