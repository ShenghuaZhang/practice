package array;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array S of n integers,
 * are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * See this with combination:
 * #TwoSum#TwoSumII#TwoSumIII#ThreeSum#ThreeSumClosest#FourSum
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<>();
		if (num==null || num.length==0)	return list;
		/* We can also use HashSet to prevent duplicate result 0-2*/
// 0	Set<List<Integer>> set = new HashSet<>();

		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if(num[i]>0) break;
			if(i>0 && num[i-1]==num[i]) continue;
			int start=i+1, end=num.length-1, target = -(num[i]);
			
			while (start<end) {
				if (num[start]+num[end] > target)	end--;
				else if (num[start]+num[end] < target)	start++;
				else {
					List<Integer> curList = new ArrayList<>(Arrays.asList(
							num[i], num[start++], num[end--]));
//	1				set.add(curList);
					list.add(curList);
					while(num[start]==num[start-1] && start<end)	start++;
					while(num[end]==num[end+1] && start<end)	end--;
				}
			}
		}
//	2	list.addAll(set);
		return list;
	}
	
	public static void main(String[] args){
		int[] num = {-1, 0, 0, 0, 1, 1, 2, -1, -4};
		System.out.print(threeSum(num));
	}
}
