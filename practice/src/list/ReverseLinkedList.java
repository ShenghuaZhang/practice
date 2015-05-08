package list;

/**
 * 206 https://leetcode.com/problemset/algorithms/
 * 
 * Reverse a singly linked list. Hint: A linked list can be reversed either
 * iteratively or recursively. Could you implement both?
 * 
 * @author yili3
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode previous = new ListNode(0), current = head;
		previous.next = head;
		while (current != null && current.next != null) {
			ListNode next = current.next;
			current.next = next.next;
			next.next = previous.next;
			previous.next = next;
		}
		return previous.next;
	}
	
	public ListNode reverseListRecursive(ListNode head){
		return helper(head, null);
	}
	private ListNode helper(ListNode current, ListNode previous){
		if(current==null)	return previous;
		ListNode next = current.next;
		current.next = previous;
		return helper(next, current);
	}
}
