package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 */

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] A){
		List<Integer> list = new ArrayList<>();
		list.add(A[0]);
		
		for(int i=1; i<A.length; i++)
			if(A[i]!=A[i-1])
				list.add(A[i]);
		System.out.print(list);
		
		return list.size();
	}
	
	public static int removeDuplicatesII(int[] A){
		if(A==null || A.length==0)  return 0;
		int temp = 1;
		for(int i=1; i<A.length; i++)
			if(A[i]!=A[i-1])	A[temp++] = A[i];
		return temp;
	}
	
	public static void main(String[] args){
		int[] A = {1,1,1,3,4,4,6,7,7,8,8,8};
		removeDuplicatesII(A);
		System.out.println(Arrays.toString(A));
	}
}
