package twoSumII;

public class SolutionII {
	public static int[] twoSumBinarySearch(int[] numbers, int target){
		int L = 0, R = numbers.length-1;
		while (L < R){
			if (numbers[L] + numbers[R] < target)
				L++;
			else if (numbers[L] + numbers[R] > target)
				R--;
			else return new int[] {L+1, R+1};
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args){
		int[] test = {1,2,3,4,5,6,7,8,9,10}, result = twoSumBinarySearch(test, 12);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
