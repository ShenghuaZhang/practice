package list;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 */
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	/*
	 * Using merge sorting
	 * Time complexity: O(n*k*logk) k is the number of list
	 * Space: O(logk)
	 */
	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return helper(lists, 0, lists.size()-1);
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
	 * TODO: merge k list using priority heap
	 * Using heap
	 * Time complexity: O(n*k*logk) k is the number of list
	 * Space: O(k)
	 */
	public ListNode mergeKListsHeap(List<ListNode> lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode n1, ListNode n2) {
						return n1.val - n2.val;
					}
				});
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node != null)	heap.offer(node);

		}
		ListNode head = null;
		ListNode pre = head;
		while (heap.size() > 0) {
			ListNode cur = heap.poll();
			if (head == null) {
				head = cur;
				pre = head;
			} else	pre.next = cur;
			pre = cur;
			if (cur.next != null)	heap.offer(cur.next);
		}
		
		return head;
	}
}
