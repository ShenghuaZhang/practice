package LinkedList;

/**
 * 206
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Reverse a singly linked list.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * 
 * @author kajia
 * #PalindromeLinkedList
 */

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		System.out.println(reverseList_jiuzhang(n1).val);
	}
	
    public static ListNode reverseList_my(ListNode head) {
        if (head == null) {
        	return null;
        }
        if (head.next == null) {
        	return head;
        }
        
        ListNode runner = head.next.next;
        ListNode walker = head.next;
        head.next = null;
        while (runner != null) {
        	walker.next = head;
        	head = walker;
        	walker = runner;
        	runner = walker.next;
        }
        walker.next = head;
        return walker;
    }
    //neat one
    public static ListNode reverseList_jiuzhang(ListNode head) {
        ListNode pre = null;
        while (head != null) {
        	ListNode temp = head.next;
        	head.next = pre;
        	pre = head;
        	head = temp;
        }
        return pre;
    }
    //recursive method
    //think about the recursive process
    public static ListNode reverseList_recursive(ListNode head) {
    	 return helper(head, null);
    }
    private static ListNode helper(ListNode head, ListNode newHead) {
    	if (head == null) {
    		return newHead;
    	}
    	ListNode temp = head.next;
    	head.next = newHead;
    	return helper(temp, head);
    }

}
