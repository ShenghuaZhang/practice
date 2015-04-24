package np;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 4.25's dp schedule
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * @author yili3
 * 
 * #Permutations
 *
 */
public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> list = new ArrayList<>();
		if(num==null ||num.length==0)	return list;
		List<Integer> temp = new ArrayList<>();
		temp.add(num[0]);
		list.add(temp);
		helper(num, 1, list);
		
		return list;
	}
	private static void helper(int[] num, int cnt, List<List<Integer>> list){
		List<List<Integer>> newList = new ArrayList<>();
		if(cnt == num.length)	return;
		for(int i=0; i<list.size(); i++){
			for(int j=0; j<list.get(i).size()+1; j++){
				List<Integer> temp = new ArrayList<>();
				temp.addAll(list.get(i));
				temp.add(j, num[cnt]);
				newList.add(temp);
			}
			
		}
		list.clear();
		list.addAll(newList);
		helper(num, ++cnt, list);
	}
}
