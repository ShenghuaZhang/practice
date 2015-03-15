package list;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/ Given a linked list,
 * reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * @author yili3
 *
 */

public class ReverseNodesInKGroup {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head==null)	return null;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead, cur = head;
		
		int cnt=0;
		while(cur!=null){
			cnt++;
			ListNode next = cur.next;
			if(cnt==k){
				pre = reverse(pre, next);
				cnt = 0;
			}
			cur = next;
		}
		
		return dummyHead.next;
	}
	private static ListNode reverse(ListNode pre, ListNode end){
		if(pre==null || pre.next==null)	return pre;
		
		ListNode head = pre.next;
		ListNode cur = pre.next.next;
		while(cur!=end){
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		head.next = end;
		return head;
	}
}
