package LinkedList;

/**
 * 234
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * @author kajia
 * 
 * #ReverseLinkedList
 */

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		System.out.println(isPalindrome_my(n1));

	}
	
    public static boolean isPalindrome_my(ListNode head) {
        int count = 0;
        ListNode temphead = head;
        temphead = head;
        System.out.println(temphead.val);
        while (temphead != null) {//I am so stupid!!!!at the beginning, I write if instead of while!!!fuck!!!
        	count++;
        	temphead = temphead.next;
        }
        System.out.println("count:" + count);
        int middle = count/2;
        
        ListNode pre = null;
        while (middle > 0) {
        	ListNode temp = head.next;
        	head.next = pre;
        	pre = head;
        	head = temp;
        	middle--;
        }
        if (count % 2 != 0) {
        	head = head.next;
        }
        
        while (head != null) {
        	if (head.val != pre.val) {
        		return false;
        	}
        	head = head.next;
        	pre = pre.next;
        }
        return true;
    }
    
    public static boolean isPalindrome_good(ListNode head) {
    	if (head == null || head.next == null) {
    		return true;
    	}
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	ListNode newhead = slow.next;
    	ListNode pre = null;
    	while (newhead != null) {
    		ListNode temp = newhead.next;
    		newhead.next = pre;
    		pre = newhead;
    		newhead = temp;
    	}
    	while (pre != null) {
    		if(pre.val != head.val) {
    			return false;
    		}
    		pre = pre.next;
    		head = head.next;
    	}
    	return true;
    }

}
