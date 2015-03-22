package list;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 */
import java.util.List;

public class MergeKSortedLists {
	/*
	 * Using merge sorting
	 * Time complexity: O(n*k*logk) k is the number of list
	 * Space: O(logk)
	 */
	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size() - 1);
	}
	private static ListNode helper(List<ListNode> lists, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			return MergeTwoSortedLists.mergeTwoLists(
					helper(lists, start, middle),
					helper(lists, middle + 1, end));
		}
		return lists.get(start);
	}
	
	/*
	 * Using heap
	 */
}
