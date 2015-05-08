package list;
/**
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * Sort a linked list using insertion sort.
 * 
 * @author yili3
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head){
		if(head == null)	return null;
		ListNode dummyHead = new ListNode(0);
		ListNode current = head;
		
		while(current!=null){
			ListNode next = current.next, p = dummyHead;
			while(p.next!=null && p.next.val<=current.val)
				p = p.next;
			current.next = p.next;
			p.next = current;
			current = next;
		}
		
		return dummyHead.next;
	}
}
