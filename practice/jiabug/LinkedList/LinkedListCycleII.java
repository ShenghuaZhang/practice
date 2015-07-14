package LinkedList;

/**
 * 142
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @author jiakangze
 *
 * #LinkedListCycle
 */

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        ListNode runner = head;
        ListNode walker = head;
        
        while (runner != null && runner.next != null) {
        	runner = runner.next.next;
        	walker = walker.next;
        	if (runner == walker) {
        		break;
        	}
        }
        if (runner == null || runner.next == null) {
        	return null;
        }
        
        while (head != runner) {
        	head = head.next;
        	runner = runner.next;
        }
        return head;
    }

}
