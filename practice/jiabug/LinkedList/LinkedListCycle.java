package LinkedList;

/**
 * 141
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @author jiakangze
 * 
 * #LinkedListCycleII
 * 
 */

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static boolean hasCycle(ListNode head) {
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            head = head.next;
            if (runner == head) {
                return true;
            }
        }
        return false;
    }

}
