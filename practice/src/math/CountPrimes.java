package math;

import java.util.BitSet;

/**
 * 204
 * https://leetcode.com/problems/count-primes/
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 * Count the number of prime numbers less than a non-negative number, n
 * 
 * @author yili3
 * 
 *         #PrimeSieve
 */
public class CountPrimes {
	public int countPrimesBitSet(int n) {
	    BitSet bs = new BitSet(n);
	    bs.set(0); bs.set(1);
	    int ind = 0, count = 0;
	    while(ind < n){
	        ind = bs.nextClearBit(ind + 1);
	        if(ind >= n)
	            return count;
	        count++;
	        for(int i = 2 * ind; i < n; i += ind)
	            bs.set(i);
	    }
	    return count;
	}

	public int countPrimes(int n) {
		int cnt = 0;
		boolean isPrime[] = new boolean[n + 1];
		for (int i = 2; i < n; i++)
			isPrime[i] = true;
		for (int i = 2; i * i < n; i++) {
			if (isPrime[i]) {
				for (int j = 2; j * i < n; j++) {
					isPrime[j * i] = false;
				}
			}
		}
		for (int i = 2; i < n; i++)
			if (isPrime[i])
				cnt++;
		return cnt;
	}
}
