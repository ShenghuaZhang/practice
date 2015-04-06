package list;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head){
		if(head==null)	return false;
		ListNode slow=head, fast=head;
		
		while((fast.next)!=null && (fast.next.next)!=null){
			fast = fast.next.next;
			if(slow==fast)	return true;
			slow=slow.next;
		}
		
		return false;
	}
}
