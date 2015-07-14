package LinkedList;

/**
 * 82
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author jiakangze
 *
 */

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode deleteDuplicates(ListNode head) {
    	ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        
        while (cur != null) {
        	if (cur.next != null && cur.val == cur.next.val) {
        		while (cur.next != null && cur.val == cur.next.val) {
        			cur = cur.next;
        		}
        		pre.next = cur.next;
        	} else {
        		pre = pre.next;
        	}
        	cur = cur.next;
        }
        return helper.next;
    }
    
    public static ListNode deleteDuplicates_ganker(ListNode head) {
    	ListNode helper = new ListNode(0);
    	helper.next = head;
    	ListNode pre = helper;
    	ListNode cur = head;
    	
    	while (cur != null) {
    		while (cur.next != null && cur.val == cur.next.val) {
    			cur = cur.next;
    		}
    		
    		if (pre.next == cur) {//in here, we compare the address, not value
    			pre = pre.next;
    		} else {
    			pre.next = cur.next;
    		}
    		cur = cur.next;
    	}
    	return helper.next;
    }

}
