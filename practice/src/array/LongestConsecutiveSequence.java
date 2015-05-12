package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 128
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num){
		if(num==null || num.length==0)	return 0;
		Set<Integer> set = new HashSet<>();
		for(int i:num)	set.add(i);
		
		int max=1;
		while(!set.isEmpty()){
			Iterator<Integer> iter = set.iterator();
			int item = (Integer)iter.next();
			set.remove(item);
			int len = 1, i = item-1;
			while(set.contains(i)){
				set.remove(i--);
				len++;
			}
			i=item+1;
			while(set.contains(i)){
				set.remove(i++);
				len++;
			}
			if(len>max)	max=len;
		}
		return max;
    }
}
