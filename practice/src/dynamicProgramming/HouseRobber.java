package dynamicProgramming;

/**
 * 198
 * https://leetcode.com/problems/house-robber/
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author carllee1991
 *
 */
public class HouseRobber {
	public static int rob(int[] nums) {
		if(nums==null || nums.length==0)    return 0;
        if(nums.length==1)  return nums[0];
        if(nums.length==2)  return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length+1];
        dp[0] = 0; dp[1]=nums[0];
        
        for(int i=2; i<=nums.length; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
            
        return dp[nums.length];
	}
	
	public int robWithExtraSpace(int[] nums) {
        if(nums==null || nums.length==0)    return 0;
        if(nums.length==1)  return nums[0];
        if(nums.length==2)  return Math.max(nums[0], nums[1]);
        
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++)
            nums[i] = Math.max(nums[i-2]+nums[i], nums[i-1]);
            
        return nums[nums.length-1];
    }

	public static void main(String[] args) {
		int[] num = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108,
				200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165,
				195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78,
				188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
		System.out.print(rob(num));
	}
}
