package array;

import java.util.ArrayList;
import java.util.LinkedList;
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
	class Interval{
		int start, end;
		Interval(){	start = 0;	end = 0;}
		Interval(int s, int e){	start = s;	end = e;}
	}
	
	List<Interval> insert(List<Interval> intervals, Interval newInterval){
		if(newInterval ==null)	return intervals;
		List<Interval> list = new ArrayList<>();
        if(intervals == null || intervals.size()<1){
        	list.add(newInterval);
        	return list;
        }
		
		boolean finished = false;
		for(int i=0; i<intervals.size(); i++){
			if(finished || intervals.get(i).end < newInterval.start){
				list.add(intervals.get(i));
				continue;
			}
			
			// find start point
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			
			// find end point
			if(intervals.get(i).start > newInterval.end){
				list.add(newInterval);
				list.add(intervals.get(i));
				finished = true;
			}
			else if(intervals.get(i).end >= newInterval.end){
				list.add(new Interval(newInterval.start, intervals.get(i).end));
				finished = true;
			}
		}
		
		if(!finished)	list.add(newInterval);
		
		return list;
	}
	/**
	 * Change input type to LinkedList.
	 * Make a in-place algorithm(actually the same...)
	 * BUT! Insertion of LinkedList is O(1), so time complexity still O(n)
	 */
	void insert(LinkedList<Interval> intervals, Interval newInterval){
		if(newInterval ==null)	return;
        if(intervals == null || intervals.size()<1){
        	intervals.add(newInterval);
        	return;
        }
        
		for(int i=0; i<intervals.size(); i++){
			// find start point
			if(intervals.get(i).end >= newInterval.start)
				newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			
			// find end point
			if(intervals.get(i).start > newInterval.end){
				intervals.add(i, newInterval);
				return;
			} else if(intervals.get(i).end >= newInterval.end){
				intervals.add(i, new Interval(newInterval.start, intervals.get(i).end));
				return;
			}
		}
		
		intervals.add(newInterval);
	}
	/**
	 * If has collision, return false, else same as first
	 */
	boolean insertWithoutCollision(List<Interval> intervals, Interval newInterval){
		int left = 0, right = intervals.size(), middle = (left+right)>>>2;
		
		for(; left<right; middle=(left+right)>>>2){
			if(intervals.get(middle).start > newInterval.start)	right = middle+1;
			else if(intervals.get(middle).start < newInterval.start){
				if(intervals.get(middle+1).start > newInterval.start) break;
				left = middle-1;
			}
			else return false;
		}
		
		if(intervals.get(middle+1).start < newInterval.end)	intervals.add(middle+1, newInterval);
		else return false;
		
		return true;
	}
}
