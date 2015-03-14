package list;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head){
		if(head==null)	return false;
		ListNode slow=head, fast=head;
		
		while((fast=fast.next)!=null && (fast=fast.next)!=null){
			if(slow==fast)	return true;
			slow=slow.next;
		}
		
		return false;
	}
}
