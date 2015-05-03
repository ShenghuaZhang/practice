package np;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * 
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author yili3
 *
 */
public class Permutations {
	public List<List<Integer>> premute(int[] num){
		List<List<Integer>> list = new ArrayList<>();
		if(num==null ||num.length==0)	return list;
		
		List<Integer> temp = new ArrayList<>();
		temp.add(num[0]);
		list.add(temp);
		helper(num, 1, list);
		
		return list;
	}
	private void helper(int[] num, int cnt, List<List<Integer>> list){
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
