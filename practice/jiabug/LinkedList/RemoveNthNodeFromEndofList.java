package LinkedList;

/**
 * 19
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author jiakangze
 *
 */

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) {
    		return null;
    	}
    	ListNode runner = head;
        ListNode walker = head;
        int gap = 0;
        while(gap != n && runner != null) {
        	runner = runner.next;
        	gap++;
        }
        //if n is not valid!!!!! we should consider this situation.
        if(runner == null) {
        	if(gap == n) {
        		return head.next;
        	} else {
        		return head;
        	}
        }
        while(runner.next != null) {
        	runner = runner.next;
        	walker = walker.next;
        }
        
        walker.next = walker.next.next;
        return head;
        
    }

}
