package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * @author yili3
 *
 */
public class MergeIntervals {
	public class Interval{
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e){start = s; end = e;}
	}
	
	public List<Interval> merge(List<Interval> intervals){
		if(intervals==null || intervals.size()<2)	return intervals;
		
		List<Interval> res = new ArrayList<>();
		// TODO: How to use comparator
		Comparator<Interval> cmp = new Comparator<Interval>(){
			public int compare(Interval first, Interval second){
				if(first.start == second.start)
					return first.end-second.end;
				return first.start-second.start;
			}
		};
		Collections.sort(intervals, cmp);
		
		res.add(intervals.get(0));
		for(int i=1; i<intervals.size(); i++){
			if(res.get(res.size()-1).end>=intervals.get(i).start)
				res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
			else res.add(intervals.get(i));
		}
		
		return res;
	}
}
