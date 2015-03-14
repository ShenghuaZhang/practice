package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num){
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
	
	public static void main(String[] args){
		System.out.print(longestConsecutive(new int[]{1,1,1,2,2,2,2,3,4,4}));
	}
}
