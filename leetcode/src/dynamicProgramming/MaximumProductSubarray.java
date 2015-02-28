package dynamicProgramming;

public class MaximumProductSubarray {
	public int maxProduct(int[] A){
		if(A==null || A.length==0)	return 0;
		int global = A[0], localMax = A[0], localMin = A[0];
		for(int i=1; i<A.length; i++){
			int temp = localMin;
			localMin = Math.min(Math.min(A[i], localMin*A[i]), A[i]*localMax);
			localMax = Math.max(Math.max(A[i], localMax*A[i]), A[i]*temp);
			
			global = Math.max(global, localMax);
		}
		return global;
	}
}
