package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> list = new ArrayList<>();
		if (num==null || num.length==0)	return list;

		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if(num[i]>0) break;
			if(i>0 && num[i-1]==num[i]) continue;
			list.addAll(helper(num, i));
		}
		
		return list;
	}
	private static List<List<Integer>> helper(int[] num, int index) {
		List<List<Integer>> list = new ArrayList<>();
		int start = index + 1, end = num.length-1, target = -(num[index]);
		
		while (start<end) {
			if (num[start]+num[end] > target)	end--;
			else if (num[start]+num[end] < target)	start++;
			else {
				List<Integer> curList = new ArrayList<>(Arrays.asList(
						num[index], num[start++], num[end--]));
				list.add(curList);
				while(num[start]==num[start-1] && start<end)	start++;
				while(num[end]==num[end+1] && start<end)	end--;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args){
		int[] num = {-1, 0, 0, 0, 1, 1, 2, -1, -4};
		System.out.print(threeSum(num));
	}
}
