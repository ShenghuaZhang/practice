package list;

public class WeavingTwoLinkedlist {
	public static ListNode weavingList(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while(l1!=null && l2!=null){
			p.next = l1;
			p.next.next = l2;
			l1 = l1.next;
			l2 = l2.next;
			p = p.next.next;
		}
		if(l1!=null)	p.next = l1;
		if(l2!=null)	p.next = l2;
		return dummyHead.next;
	}
}
