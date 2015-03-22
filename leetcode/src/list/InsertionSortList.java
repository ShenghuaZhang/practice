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
		
		while(head!=null){
			ListNode next = head.next, p = dummyHead;
			while(p.next!=null & p.next.val<=head.val)
				p = p.next;
			head.next = p.next;
			p.next = head;
			head = next;
		}
		
		return dummyHead.next;
	}
}
