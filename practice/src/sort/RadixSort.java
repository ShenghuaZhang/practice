package sort;

import java.util.Arrays;

public class RadixSort {
	public static void radixSort(int[] A){
		int n=1, length=A.length;
		int[][] bucket = new int[10][length];
		int[] order= new int[10];
		
		int max = A[0];
		for(int num:A)	max=Math.max(max, num);
		
		while(n<=max){
			for(int num:A){
				int digit = (num/n) % 10;
				bucket[digit][order[digit]] = num;
				order[digit]++;
			}
			for(int i=0, k=0; i<10; i++){
				for(int j=0; j<order[i]; j++)
					A[k++] = bucket[i][j];
				order[i] = 0;
			}
			n*=10;
		}
	}
	
	public static void main(String[] args){
		int[] A = {1, 100000};
		radixSort(A);
		System.out.println(Arrays.toString(A));
	}
}
