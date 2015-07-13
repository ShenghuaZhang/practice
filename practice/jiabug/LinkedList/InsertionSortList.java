package LinkedList;

/**
 * 147
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * Sort a linked list using insertion sort.
 * 
 * @author kajia
 *
 */

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode insertionSortList_my(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        ListNode runner = head.next;
        ListNode walker = head;
        while (runner != null) {
        	ListNode pre = head;
        	ListNode after = head.next;
        	while (runner.val > after.val) {
        		pre = pre.next;
        		after = after.next;
        	}
        	if (pre.val > runner.val && pre == head) {
        		walker.next = runner.next;
        		runner.next = pre;
        		head = runner;
        		runner = walker.next;
        	} else if (after.val >= runner.val && after != runner){
        		walker.next = runner.next;
        		runner.next = after;
        		pre.next = runner;
        		runner = walker.next;
        	} else {
        		runner = runner.next;
        		walker = walker.next;
        	}
        }
        return head;
    }
    
    
    //build a new linker list for sorted linked list.
    public static ListNode insertionSortList_ganker(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	
    	ListNode helper = new ListNode(0);
    	
    	ListNode cur = head;
    	
    	while (cur != null) {
    		ListNode temp = cur.next;
    		ListNode pre = helper;
    		
    		while (pre.next != null && pre.next.val <= cur.val) {
    			pre = pre.next;
    		}
    		
    		cur.next = pre.next;
    		pre.next = cur;
    		cur = temp;
    		
    	}
    	return helper.next;
    }

}
