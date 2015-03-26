package sort;

import java.util.Arrays;

public class RadixSort {
	public static void radixSort(int[] A){
		int n=1, k=0, length=A.length;
		int[][] bucket = new int[10][length];
		int[] order= new int[length];
		
		int max = A[0];
		for(int num:A)	max=Math.max(max, num);
		
		while(n<max){
			for(int num:A){
				int digit = (num/n) % 10;
				bucket[digit][order[digit]] = num;
				order[digit]++;
			}
			for(int i=0; i<10; i++){
				for(int j=0; j<order[i]; j++)
					A[k++] = bucket[i][j];
				order[i] = 0;
			}
			n*=10;
			k=0;
		}
	}
	
	public static void main(String[] args){
		int[] A = {12,13,14,45,65,76,36,45,90,87,97,56,76,1,4,6,8,9};
		radixSort(A);
		System.out.println(Arrays.toString(A));
	}
}
