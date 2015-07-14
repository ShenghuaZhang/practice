package LinkedList;

/**
 * 24
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author jiakangze
 *
 */

public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode swapPairs_yi(ListNode head) {
    	ListNode helper = new ListNode(0);
    	helper.next = head;
    	ListNode pre = helper;
    	ListNode cur = head;
    	while (cur != null && cur.next != null) {
    		ListNode next = cur.next;
    		pre.next = next;
    		cur.next = next.next;
    		next.next = cur;
    		pre = cur;
    		cur = cur.next;
    	}
    	
    	return helper.next;
    }

}
