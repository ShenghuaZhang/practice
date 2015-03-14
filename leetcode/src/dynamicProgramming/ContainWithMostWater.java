package dynamicProgramming;

public class ContainWithMostWater {
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
