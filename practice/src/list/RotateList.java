package list;
/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places,
 * where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author yili3
 *
 */
public class RotateList {
	public ListNode rotateRightMine(ListNode head, int k){
		if(head==null || k==0)	return head;
		int length = 0;
		ListNode current = head, last = current;
		while(current!=null){
			length++;
			if(current.next==null){
				last = current;
				break;
			}
			current=current.next;
		}
		if(k%length==0)	return head;
		length -= (k%length);
		
		current = head;
		while(length-1>0){
			current=current.next;
			length--;
		}
		ListNode newHead = current.next;
		current.next=null;
		last.next = head;
		
		return newHead;
	}
	
	public ListNode rotateRight(ListNode head, int k){
		if(head==null || k==0)	return head;
		ListNode slow=head, fast=head;
		int index = 0;
		while(fast!=null && index < k){
			fast = fast.next;
			index++;
		}
		if(fast==null){
			k %= index;
			if(k==0)	return head;
			index = 0;
			fast = head;
			while(index<k){
				fast = fast.next;
				index++;
			}
		}
		while(fast.next!=null){
			fast= fast.next;
			slow = slow.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		
		return newHead;
	}
}
