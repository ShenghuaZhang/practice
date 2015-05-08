package list;

public class RemoveNthNodeFromEndOfList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head, walker = head;
        int i=0;
        for(; i<n && runner!=null; i++)  runner = runner.next;
        if(i<n)    return head;
        if(runner==null)    return head.next;	// when i==n
        while(runner.next!=null){
            walker=walker.next;
            runner=runner.next;
        }
        walker.next = walker.next.next;
        return head;
    }
	
	public static void main(String[] args){
		ListNode head = ListNode.LeetcodeInitialize("(200,11,3,4,23,85,26)");
		ListNode.print(removeNthFromEnd(head, 4));
	}
}
