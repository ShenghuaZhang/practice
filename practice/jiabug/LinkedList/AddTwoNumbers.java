package LinkedList;

/**
 * 2
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * 
 * @author jiakangze
 *
 */


public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        }
        if (l2 == null) {
        	return l1;
        }
        ListNode helper = new ListNode(0);
        
        ListNode cur = helper;
        int digit = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
        	int x = (l1 == null? 0 : l1.val);
        	int y = (l2 == null? 0 : l2.val);
        	
        	digit = x + y + carry;
        	
        	cur.next = new ListNode(digit%10);
        	carry = digit / 10;
        	cur = cur.next;
        	
        	if (l1 != null) {
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		l2 = l2.next;
        	}
        }
        if (carry != 0) {
        	cur.next = new ListNode(carry);
        }
        return helper.next;
    }

}
