package sort;

import java.util.Arrays;

public class ShellSort {
	public static void shellSort(int[] A){
		int h=1;
		while(h<A.length/3)	h=h*3+1;
		
		for(;h>0;h=(h-1)/3){
			for(int i=h; i<A.length; i++)
				for(int j=i; j>h-1 && A[j-h]>=A[j]; j-=h)
					BubbleSort.swap(A, j, j-h);
		}
	}
	
	public static void shellSortMine(int[] A){
		helper(A, 1, false);
	}
	private static void helper(int[] A, int h, boolean flag){
		if(h<1)	return;
		if(h >= A.length)	helper(A, (h-1)/3, true);
		else if(flag == true){
			for(int i=h; i<A.length; i++){
				for(int k=i; k>h-1 && A[k]<A[k-h]; k-=h)
					BubbleSort.swap(A, k, k-h);
			}
			if(h==1)	return;
			else helper(A, (h-1)/3, true);
		}
		else helper(A, h*3+1, flag);
	}
	
	public static void main(String[] args){
		int[] A = {2,2,3,4,46,9,5,34,56,2,34,523,6,76,3,7,7,90};
		shellSort(A);
		System.out.print(Arrays.toString(A));
	}
}
