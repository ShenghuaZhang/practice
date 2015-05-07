package list;

/**
 * 23
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	/*
	 * Using merge sorting
	 * Time complexity: O(n*k*logk) k is the number of list
	 * Space: O(logk)
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)  return null;
       	return helper(lists, 0, lists.length-1);
    }
    private ListNode helper(ListNode[] lists, int start, int end){
        if(start<end){
            int middle = (start+end)/2;
            return mergeList(helper(lists, start, middle), helper(lists, middle+1, end));
        }
        return lists[start];
    }
    private ListNode mergeList(ListNode first, ListNode second){
        ListNode dummyHead = new ListNode(0), previous = dummyHead;
        while(first!=null && second!=null){
            if(first.val>second.val){
                previous.next = second;
                second=second.next;
            }else{
                previous.next = first;
                first= first.next;
            }
            previous=previous.next;
        }
        if(first!=null) previous.next =first;
        if(second!=null)    previous.next =second;
        
        return dummyHead.next;
    }

	/*
	 * Using heap
	 * Time complexity: O(n*k*logk) k is the number of list
	 * Space: O(k)
	 * PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
	 * Creates a PriorityQueue with the specified initial capacity that orders
	 * its elements according to the specified comparator.
	 */
	public ListNode mergeKListsHeap(ListNode[] lists) {
		if(lists==null || lists.length==0)  return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>() {
					public int compare(ListNode n1, ListNode n2) {
						return n1.val - n2.val;
					}
				});
		
		for (int i = 0; i < lists.length; i++)
			if (lists[i] != null)
				heap.offer(lists[i]);
		
		ListNode dummyHead = new ListNode(0), previous = dummyHead;
		while (heap.size() > 0) {
			ListNode current = heap.poll();
			if (current.next != null)
				heap.offer(current.next);
			previous.next = current;
			previous = current;
		}

		return dummyHead.next;
	}
}
