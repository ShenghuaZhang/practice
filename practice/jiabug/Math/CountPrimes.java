package Math;

/**
 * 204
 * https://leetcode.com/problems/count-primes/
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * 
 * @author jiakangze
 *
 * same with Sieve_of_Eratosthenes
 */


public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		System.out.println(countPrimes(n));

	}
	
    public static int countPrimes(int n) {
    	if (n <= 1) {
    		return 0;
    	}
    	
        boolean [] flags = new boolean[n];
        
        for (int i = 2; i < flags.length; i++) {
        	flags[i] = true;
        }
        
        int prime = 2;
        
        while (prime < Math.sqrt(n)) {
        	setFalse(flags, prime);
        	prime = nextPrime(flags, prime);
        	
        	if (prime > flags.length) {
        		break;
        	}
        }
        
        int count = 0;
        for (boolean b : flags) {
        	if (b == true) {
        		count++;
        	}
        }
        return count;
    }
    
    public static void setFalse(boolean [] flags, int prime) {
    	for (int i = prime * prime; i < flags.length; i += prime) {
    		flags[i] = false;
    	}
    }
    
    public static int nextPrime(boolean [] flags, int prime) {
    	int next = prime + 1;
    	while (next < flags.length && !flags[next]) {
    		next++;
    	}
    	return next;
    }

}
