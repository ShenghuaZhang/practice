package list;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode previous=dummyHead, current=head;
		while(current!=null && current.next!=null) {
			ListNode next = current.next, end = next.next;
			previous.next = next;
			next.next = current;
			current.next = end;
			previous = current;
			current = end;
		}
		return dummyHead.next;
	}
}
