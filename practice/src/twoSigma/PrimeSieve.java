package twoSigma;

import java.util.Scanner;

/**
 * http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
 * 
 * @author yili3
 *
 * #CountPrimes
 */
public class PrimeSieve {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] isPrime = new boolean[N+1];
		for(int i=2; i<=N; i++)	isPrime[i] = true;
		
		for(int i=2; i*i<=N; i++){
			if(isPrime[i]){
				for(int j=i; i*j<=N; j++){
					isPrime[i*j] = false;
				}
			}
		}
		
		for(int i=2; i<=N; i++)
			if(isPrime[i]) System.out.print(i+" ");
	}
}
