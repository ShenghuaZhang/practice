package list;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head, walker = head;
        int i=0;
        for(; i<n && runner!=null; i++)  runner = runner.next;
        if(i<n)    return head;
        if(runner==null)    return head.next;
        while(runner.next!=null){
            walker=walker.next;
            runner=runner.next;
        }
        walker.next = walker.next.next;
        return head;
    }
}
