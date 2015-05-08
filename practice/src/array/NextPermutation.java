package array;
/**
 * 31
 * https://leetcode.com/problems/next-permutation/
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * @author carllee1991
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)	return;
		
		int i = nums.length-2;
		for (; i>=0; i--)	if (nums[i]<nums[i+1])	break;
		if(i==-1){
			reverse(nums, 0, nums.length-1);
			return;
		}
		for (int j=nums.length-1; ; j--) {
			if (nums[j] > nums[i]) {
				swap(nums, i, j);
				reverse(nums, i + 1, nums.length - 1);
				return;
			}
		}
	}
	
	private void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	private void reverse(int[] nums, int left, int right) {
		for (; left < right; left++, right--)
			swap(nums, left, right);
	}
}
