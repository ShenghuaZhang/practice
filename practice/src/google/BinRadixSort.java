package google;

import java.util.Arrays;

public class BinRadixSort {
	public static void binSort(int[] n){
		for(int i=0; i<n.length; i++){
			while(i!=n[i]){
				int temp = n[i];
				n[i] = n[temp];
				n[temp]=temp;
			}
		}
	}
	
	public static void radixSort(int[] n){
		int[][] radix = new int[10][n.length];
		int[] order = new int[10];
		int k = 0;
		
		int max = n[0];
		for(int num:n)	max = Math.max(max, num);
		
		for(int digit=1; digit<=max; digit*=10,k=0){
			for(int num:n){
				int x = (num/digit) % 10;
				radix[x][order[x]] = num;
				order[x]++;
			}
			for(int i=0; i<10; i++){
				for(int j=0; j<order[i]; j++)
					n[k++] = radix[i][j];
				order[i] = 0;
			}
		}
	}
	
	public static void main(String[] args){
		int[] n = {2,6,3,4,5,0,7,1,9,8};
		int[] m = {12,16,31,4,15,20,27,41,79,48};
		binSort(n);
		radixSort(m);
		System.out.println(Arrays.toString(n)+"\n"+Arrays.toString(m));
	}
}
