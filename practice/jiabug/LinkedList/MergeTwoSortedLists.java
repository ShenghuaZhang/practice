package LinkedList;

/**
 * 21
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author jiakangze
 *
 */

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mergeTwoLists(null,null));

	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode newHead = new ListNode(0);//the next if null by default
    	ListNode head = newHead;
        while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		head.next = l1;
        		l1 = l1.next;
        	} else {
        		head.next = l2;
        		l2 = l2.next;
        	}
        	head = head.next;
        }
        if (l1 != null) {
        	head.next = l1;
        }
        if (l2 != null) {
        	head.next = l2;
        }
        return newHead.next;
    }
    
    public static ListNode mergeTwoLists_ganker(ListNode l1, ListNode l2) {
    	ListNode newHead = new ListNode(0);
    	
    	newHead.next = l1;
    	
    	ListNode pre = newHead;
    	while (l1 != null && l2 != null) {
    		if (l1.val > l2.val) {
    			ListNode temp = l2.next;
    			l2.next = l1;
    			pre.next = l2;
    			l2 = temp;
    			
    		} else {
    			l1 = l1.next;
    		}
    		pre = pre.next;
    	}
    	if (l2 != null) {
    		pre.next = l2;
    	}
    	return newHead.next;
    }

}
