package math;

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
	public int countPrimes(int n) {
		int cnt = 0;
		boolean isPrime[] = new boolean[n];
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
