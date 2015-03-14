package array;

public class FirstMissingPositive {
	/***************** 0 *****************/
	// If it is sorted array, using binary search
	public static int firstMissingPositiveSortedArray(int[] A) {
		int positive = 1;
        while(bs(A, positive, 0, A.length-1))	positive++;
        
        return positive;
    }
    private static boolean bs(int[] A, int positive, int begin, int end){
    	if(begin>end)	return false;
        int middle = (begin+end)/2;
        if(A[middle]==positive)	return true;
        else if(A[middle]>positive)	return bs(A, positive, begin, middle-1);
        else return bs(A, positive, middle+1, end);
    }
    
    public static void main(String[] args){
    	int[] A = {1,2,3,5};
    	System.out.print(firstMissingPositiveSortedArray(A));
    }
    
    /***************** 1 *****************/
    // unsorted array using counting sort
    public static int firstMissingPositive(int[] A){
    	if(A==null || A.length==0)	return 1;
    	for(int i=0; i<A.length; i++){
    		if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
    			int temp = A[A[i]-1];
    			A[A[i]-1] = A[i];
    			A[i] = temp;
    			i--;
    		}
    	}
    	for(int i=0; i<A.length; i++){
    		if(A[i]!=i+1)	return i+1;
    	}
    	
    	return A.length+1;
    }
}
