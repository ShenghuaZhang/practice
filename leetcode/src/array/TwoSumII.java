package array;

/**
 * 167
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Same with Two sum but input array is sorted in ascending order
 * @return An array which include two integers.
 * 
 * See this with combination:
 * #TwoSum#TwoSumII#TwoSumIII#ThreeSum#ThreeSumClosest#FourSum
 */

public class TwoSumII {
	public int[] twoSumBetter(int[] numbers, int target){
		int start = 0, end = numbers.length-1;
		while(start<end){
			if (numbers[start]+numbers[end] > target)	end--;
			else if (numbers[start]+numbers[end] < target)	start++;
			else return new int[]{start+1, end+1};
		}
		return null;
	}
	
	public int[] twoSum(int[] numbers, int target){
		for(int i=0; i<numbers.length; i++){
			if (numbers[i]>target-numbers[i])	return null;
			int rs = bsearch(numbers, target-numbers[i], i+1);
			if (rs >= 0)	return new int[]{i+1, rs+1};
		}
		return null;
	}
	private int bsearch(int[] numbers, int target, int start){
		int end = numbers.length-1, middle = (start+end)/2;
		for(; start<=end; middle=(end+start)/2){
			if(numbers[middle] > target)	end = middle-1;
			else if (numbers[middle] < target)	start = middle+1;
			else return middle;
		}
		return -1;
	}
}
