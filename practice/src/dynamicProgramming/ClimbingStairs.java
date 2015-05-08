package dynamicProgramming;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int f0 = 1, f1 = 1, f2 = 2;
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		for (int i = 2; i <= n; i++) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}
}
