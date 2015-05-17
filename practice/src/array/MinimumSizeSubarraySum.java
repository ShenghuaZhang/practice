package array;
/**
 * 209
 * 
 * @author carllee1991
 *
 */
public class MinimumSizeSubarraySum {
	/* This algorithm is pretty much like the algorithm use in #MaximumRangeNumber*/
	public int minSubArrayLen(int s, int[] nums){
		int length = -1, current = 0, left=0, right=0;
		while(right<nums.length){
			current+=nums[right];
			while(current>=s){
				if(left>right)	return 1;
				if(length>0)	length = Math.min(length, right-left+1);
				else length = right-left+1;
				current-=nums[left];
				left++;
			}
			if(current<s)	right++;
		}
		if(current<s && length==-1)	return 0;
		return length;
	}
}
