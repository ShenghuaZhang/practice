package LinkedList;

/**
 * 61
 * https://leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author kajia
 *
 */

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode rotateRight_my(ListNode head, int k) {
    	if (head == null) {
    		return null;
    	}
        int length = 1;
        ListNode last = head;
        while (last.next != null) {
        	last = last.next;
        	length++;
        }
        int rotate = k % length;
        
        if (rotate == 0) {
        	return head;
        }
        
        ListNode walker = head;
        ListNode runner = head;
        
        while (rotate != 0) {
        	runner = runner.next;
        	rotate--;
        }
        while (runner.next != null) {
        	runner = runner.next;
        	walker = walker.next;
        }
        
        ListNode newhead = walker.next;
        runner.next = head;
        walker.next = null;
        
        return newhead;
    }
}
