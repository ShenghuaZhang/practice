package array;
/**
 * TODO 81
 * 
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * 
 * @author carllee1991
 * 
 * #FindMinimumInRotatedSortedArray
 *
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target){
		return helper(nums, target, 0, nums.length-1);
	}
	private boolean helper(int[] nums, int target, int left, int right){
		if(nums[left]<target && nums[right]<target && nums[left]<=nums[right])
			return helper(nums, target, right+1, right+(left+right)/2);
		else if(nums[left]<target)
			return helper(nums, target, left+1, (left+right)/2);
		else if(nums[left]>target && nums[right]>target && nums[left]<=nums[right])
			return helper(nums, target, right+1, right+(left+right)/2);
		else if(nums[left]>target)
			return helper(nums, target, (left+right)/2, right-1);
			
		else return true;
	}
}
