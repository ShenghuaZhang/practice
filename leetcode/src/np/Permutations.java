package np;

import java.util.ArrayList;
import java.util.List;

/**
 * 46
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
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0)    return list;
        boolean[] used = new boolean[nums.length];
        helper(nums, list, new ArrayList<Integer>(), used);
        return list;
    }
    private void helper(int[] nums, List<List<Integer>> list, List<Integer> current, boolean[] used){
        if(current.size()==nums.length){
            list.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                current.add(nums[i]);
                helper(nums, list, current, used);
                current.remove(current.size()-1);
                used[i] = false;
            }
        }
    }
    
	public List<List<Integer>> permuteIterator(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		if(nums==null ||nums.length==0)	return list;
		
		List<Integer> first = new ArrayList<>();
		first.add(nums[0]);
		list.add(first);
		
		for(int i=1; i<nums.length; i++){
			List<List<Integer>> newList = new ArrayList<>();	
			for(int j=0; j<list.size(); j++){
				for(int k=0; k<list.get(j).size()+1; k++){
					List<Integer> item = new ArrayList<Integer>(list.get(j));
					item.add(k, nums[i]);
					newList.add(item);
				}
			}
			list = newList;
		}
		return list;
	}
}
