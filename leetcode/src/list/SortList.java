package list;
/**
 * https://leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author yili3
 *
 */
public class SortList {
	public static ListNode sortList(ListNode head){
		if(head==null || head.next==null)	return head;
		ListNode fast = head, slow = head;
		
		while(fast.next!=null & fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		ListNode head1 = head;
		head1 = sortList(head1);
		head2 = sortList(head2);
		return MergeTwoSortedLists.mergeTwoLists(head1, head2);
	}
}
