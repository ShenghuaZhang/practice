package list;
/**
 * https://leetcode.com/problems/reorder-list/
 * 
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * #ReverseLinkedListII
 * 
 * @author yili3
 *
 */
public class ReorderList {
	public static void reorderList(ListNode head){
		if(head==null || head.next==null || head.next.next==null)	return;
		ListNode slow=head, fast=head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode head1 = head, head2 = slow.next;
		slow.next = null;
		head2=reverse(head2);
		
		while(head1!=null && head2!=null){
			ListNode next2 = head2.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			head2 = next2;
		}
	}
	protected static ListNode reverse(ListNode head){
		ListNode previous = null, current = head;
		
		while(current!=null){
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	protected static ListNode reverseRecursive(ListNode head){
		if(head==null || head.next==null)	return head;
		ListNode next = head.next;
		head.next = null;
		return reverseRecursive(head, next);
	}
	private static ListNode reverseRecursive(ListNode current, ListNode next){
		if(next==null)	 return current;
		ListNode head = reverseRecursive(next, next.next);
		next.next = current;
		return head;
	}
	
	public static void reorderListMine(ListNode head){
		if(head==null || head.next==null || head.next.next==null)	return;
		
		ListNode slow=head, fast=head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode second = slow.next;
		slow.next = null;
		slow = second;
		if(fast.next!=null)	fast = fast.next;
		second = new ListNode(fast.val);
		while(fast!=slow){
			ListNode temp = second.next;
			second.next = new ListNode(slow.val);
			second.next.next = temp;
			slow = slow.next;
		}
		
		while(second!=null){
			ListNode next1 = head.next, next2=second.next;
			head.next=second;
			second.next = next1;
			second=next2;
			head = next1;
		}
	}
	
	public static void main(String[] args){
		ListNode head = ListNode.initial(), rHead = reverseRecursive(head);
		ListNode.print(rHead);
	}
}
