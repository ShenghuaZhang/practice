package list;
/**
 * TODO: Practice one more time
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Reverse a linked list from position m to n.
 * Do it in-place and in one-pass.
 * 
 * For example: 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 * 
 * @author yili3
 *
 */
public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(head==null || m==n)  return head;
		ListNode dummyHead = new ListNode(0), previous = dummyHead;
		dummyHead.next = head;
		
		int index=1;
		while(index<m){
			previous = previous.next;
			index++;
		}
		ListNode mNode = previous.next, current = mNode.next;
		while(index<n){
			mNode.next = current.next;
			current.next = previous.next;
			previous.next = current;
			current = mNode.next;
			index++;
		}
		
		return dummyHead.next;
	}
}
