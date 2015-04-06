package list;
/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author carllee1991
 *
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode previous=dummyHead, current=head;
		while(current!=null && current.next!=null) {
			ListNode next = current.next;
			previous.next = next;
			current.next = next.next;
			next.next = current;
			previous = current;
			current = current.next;
		}
		return dummyHead.next;
	}
}
