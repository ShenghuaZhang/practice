package twoSumII;

public class SolutionI {
	public static int[] twoSumBinarySearch(int[] numbers, int target){
		for(int i = 0; i < numbers.length; i++){
			int j = bsearch(numbers, target-numbers[i], i+1);
			if (j != -1)	return new int[] {i+1, j+1};
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	private static int bsearch(int[] numbers, int key, int start){
		int L = start, R = numbers.length, M = -1;
		while (L < R){
			M = (L + R) / 2;

			if (numbers[M] < key)	L = M + 1;
			else if(numbers[M] == key)	return M;
			else	R = M - 1; 
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] test = {1,2,3,4,5,6,7,8,9,10,11}, result = twoSumBinarySearch(test, 12);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
