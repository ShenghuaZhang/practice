package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary). You may assume that the intervals were
 * initially sorted according to their start times.
 * 
 * Example 1: Given intervals [1,3],[6,9]
 * insert and merge [2,5] in as [1,5],[6,9]
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16]
 * insert and merge [4,9] in as [1,2],[3,10],[12,16]
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]
 * 
 * @author yili3
 * 
 * #MergeIntervals
 *
 */
public class InsertInterval {
	public static class Interval{
		int start, end;
		Interval(){	start = 0;	end = 0;}
		Interval(int s, int e){	start = s;	end = e;}
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		if(newInterval ==null)	return intervals;
		List<Interval> list = new ArrayList<>();
        if(intervals == null || intervals.size()<1){
        	list.add(newInterval);
        	return list;
        }
		
		boolean finish = false, hasStart = false;
		int start=0;
		for(int i=0; i<intervals.size(); i++){
			if(finish || intervals.get(i).end < newInterval.start){
				list.add(intervals.get(i));
				continue;
			}
			// find start point
			if(!hasStart){
				if(intervals.get(i).start >= newInterval.start)	start = newInterval.start;
				else start = intervals.get(i).start;
				hasStart = true;
			}
			// find end point
			if(intervals.get(i).start > newInterval.end){
				list.add(new Interval(start, newInterval.end));
				list.add(intervals.get(i));
				finish = true;
			}
			else if(intervals.get(i).end >= newInterval.end){
				list.add(new Interval(start, intervals.get(i).end));
				finish = true;
			}
		}
		
		if(!finish){
		    if (hasStart)	list.add(new Interval(start, newInterval.end));
		    else list.add(newInterval);
		}
		
		return list;
	}
	
	public static void main(String[] args){
		Interval newInterval = new Interval(0, 1);
		List<Interval> intervals = new ArrayList<>();
		
		intervals.add(new Interval(1, 5));
		
		List<Interval> list = insert(intervals, newInterval);
		System.out.println(list.get(0).start);
	}
}
