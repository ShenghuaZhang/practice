package dynamicProgramming;
/**
 * 11
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author yili3
 *
 */
public class ContainerWithMostWater {
	/* Two pointer:
	 * #TwoSumII #TrappingRainWater
	 * #LongestSubstringWithoutRepeatingCharacters
	 * #LongestSubstringWithAtMostTwoDistinctCharacters
	 * #MaximumRangeNumber
	 * */
	public int maxArea(int[] height){
		int left = 0, right = height.length-1, max=0;
        while(left<right){
            max = Math.max(max, Math.min(height[left], height[right])*(right-left));
            if(height[left]>height[right])  right--;
            else left++;
        }
        return max;
	}
}
