package array;

import java.util.Stack;

/**
 * TODO 5.5 84
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],	return 10.
 * 
 * @author yili3
 * 
 * #MaximalRectangle
 * 
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {  
		if (height == null || height.length == 0)
			return 0;
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int index = stack.pop();
				int curArea = stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
				max = Math.max(max, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int curArea = stack.isEmpty() ? height.length * height[index]
					: (height.length - stack.peek() - 1) * height[index];
			max = Math.max(max, curArea);
		}
		return max;
	}
}
