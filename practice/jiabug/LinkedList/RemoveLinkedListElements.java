package LinkedList;

/**
 * 203
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @author jiakangze
 *
 */

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode removeElements_my(ListNode head, int val) {
        while (head != null && head.val == val) {
        	head = head.next;
        }
        ListNode newHead = head;
        ListNode pre = head;
        while (head != null) {
        	if (head.val == val) {
        		head = head.next;
        		pre.next = head;
        	} else {
        		pre = head;
        		head = head.next;
        	}
        }
        return newHead;
    }

}
