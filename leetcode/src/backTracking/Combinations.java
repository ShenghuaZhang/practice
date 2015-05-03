package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77
 * https://leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
 * 
 * @author yili3
 * 
 * #SubsetII
 *
 */
public class Combinations {
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> list = new ArrayList<>();
		if(n==0 || k>n) return list;
		
		helper(n, k, 1, list, new ArrayList<Integer>());
		System.out.println(list);
		return list;
	}
	private static void helper(int n, int k, int index, List<List<Integer>> list, List<Integer> current){
		if(current.size()==k){
			list.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i=index; i<=n; i++){
			current.add(i);
			helper(n, k, i+1, list, current);
			current.remove(current.size()-1);
		}
	}
	
	public static void main(String[] args){
		combine(10, 2);
	}
}
