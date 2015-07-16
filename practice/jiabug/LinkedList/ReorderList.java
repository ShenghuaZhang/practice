package LinkedList;

/**
 * 143
 * https://leetcode.com/problems/reorder-list/
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author kajia
 *
 */

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static void reorderList(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) {
    		return;
    	}
    	ListNode runner = head;
    	ListNode walker = head;
    	while (runner != null && runner.next != null) {
    		runner = runner.next.next;
    		walker = walker.next;
    	}
    	if (runner != null) {
    		walker = walker.next;
    	}
    	
    	ListNode pre = null;
    	while (walker != null) {
    		ListNode temp = walker.next;
    		walker.next = pre;
    		pre = walker;
    		walker = temp;
    	}
    	ListNode cur = head;
    	while (pre != null) {
    		ListNode tempcur = cur.next;
    		ListNode temptail = pre.next;
    		cur.next = pre;
    		pre.next = tempcur;
    		pre = temptail;
    		cur = tempcur;
    	}
    	cur.next = null;// do not forget add this !!!if not, memory limit exceeded
    }

}
