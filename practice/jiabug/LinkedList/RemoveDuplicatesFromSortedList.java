package LinkedList;

/**
 * 83
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author kajia
 *
 */


public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	
    	ListNode runner = head.next;
    	ListNode walker = head;
    	
    	while (runner != null) {
    		if (runner.val == walker.val) {
    			walker.next = runner.next;
    			runner = runner.next;
    		} else {
    			walker = walker.next;
    			runner = runner.next;
    		}
    	}
    	return head;
        
    }

}
