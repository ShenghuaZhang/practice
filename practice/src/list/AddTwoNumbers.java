package list;
/**
 * 2
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two linked lists representing two non-negative numbers.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author yili3
 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int digit = carry + x + y;
			carry = digit / 10;
			curr.next = new ListNode(digit % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0)
			curr.next = new ListNode(carry);
		return dummyHead.next;
	}
}
