package recursion;
/**
 * We can efficiently compute the gcd using the following property,
 * which holds for positive integers p and q:
 * If p > q, the gcd of p and q is the same as the gcd of q and p % q.
 */
public class EuclidAlgorithm {
	int gcd(int A, int B){
		if(B==0)	return A;
		return gcd(B, A%B);
	}
	
	public static void main(String[] args){
		EuclidAlgorithm e = new EuclidAlgorithm();
		System.out.print(e.gcd(24, 408));
	}
}
