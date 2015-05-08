package list;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author yili3
 *
 */
public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates(ListNode head){
		if(head==null || head.next==null)	return head;
		
		ListNode dummyHead = new ListNode(0), previous=dummyHead;
		dummyHead.next = head;
		
		while(previous.next!=null && previous.next.next!=null){
			ListNode current=previous.next, next=current.next;
			if(current.val==next.val){
				while(next.next!=null && next.val==next.next.val)
					next= next.next;
				previous.next = next.next;
			}
			else previous = current;
		}
		
		return dummyHead.next;
	}
}
