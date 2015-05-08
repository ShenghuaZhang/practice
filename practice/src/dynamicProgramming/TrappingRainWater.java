package dynamicProgramming;
/**
 * 42
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example, 	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author carllee1991
 *
 */
public class TrappingRainWater {
	/* Two pointer:
	 * #TwoSumII #ContainerWithMostWater
	 * #LongestSubstringWithoutRepeatingCharacters
	 * #LongestSubstringWithAtMostTwoDistinctCharacters
	 * #MaximumRangeNumber
	 * */
	public int trapBetter(int[] height) {
		int left = 0, right = height.length - 1, ret = 0;
		while (left < right) {
			if (height[left] <= height[right]) {
				int temp = left + 1;
				while (temp < right && height[left] >= height[temp])
					ret += (height[left] - height[temp++]);
				left = temp;
			} else {
				int temp = right - 1;
				while (temp > left && height[right] >= height[temp])
					ret += (height[right] - height[temp--]);
				right = temp;
			}
		}
		return ret;
	}
	
	/* DP:
	 * #Candy #LongestPalindromicSubstring
	 * */
	public int trap(int[] height){
		if(height==null || height.length==0)	return 0;
		int max=height[0], res=0;
		int[] container = new int[height.length];
		
		for(int i=1; i<height.length-1; i++){
			container[i] = max;
			max = Math.max(max, height[i]);
		}
		max = height[height.length-1];
		for(int i=height.length-2; i>0; i--){
			container[i] = Math.min(max, container[i]);
			res += container[i]-height[i]>0?container[i]-height[i]:0;
			max = Math.max(max, height[i]);
		}
		return res;
	}
}
