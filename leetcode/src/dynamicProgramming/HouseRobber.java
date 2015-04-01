package dynamicProgramming;

/**
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
	public static int rob(int[] num) {
		if(num.length==0 || num==null)	return 0;
		if(num.length==1)	return num[0];
		if(num.length==2)	return Math.max(num[1], num[0]);
		if(num.length==3)	return Math.max(num[1], num[0]+num[2]);
		
		num[2] = Math.max(num[1], num[0]+num[2]);
		for(int i=3; i<num.length; i++)
			num[i] = num[i] + Math.max(num[i-2], num[i-3]);
		
		return Math.max(num[num.length-1], num[num.length-2]);
	}

	public static void main(String[] args) {
		int[] num = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108,
				200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165,
				195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78,
				188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
		System.out.print(rob(num));
	}
}
