package LinkedList;

/**
 * 92
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author jiakangze
 *
 */

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode reverseBetween_my(ListNode head, int m, int n) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        
        int i = 1;
        while (i < m) {
        	pre = pre.next;
        	cur = cur.next;
        	i++;
        }
        
        ListNode tail = cur;
        
        ListNode newHead = null;
        
        while (i <= n) {
        	ListNode temp = cur.next;
        	cur.next = newHead;
        	newHead = cur;
        	cur = temp;
        	i++;
        }
        
        pre.next = newHead;
        
        tail.next = cur;
        
        return helper.next;
    }
    //good idea
    public static ListNode reverseBetween_ganker_simple(ListNode head, int m, int n) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	
    	int i = 1;
    	
    	while (i < m) {
    		pre = pre.next;
    		i++;
    	}
    	
    	
    	ListNode mNode = pre.next;
    	ListNode cur = mNode.next;
    	
    	while (i < n) {
    		ListNode temp = cur.next;
    		cur.next = pre.next;
    		pre.next = cur;
    		mNode.next = temp;
    		cur = temp;
    		i++;
    	}
    	return dummy.next;
    }
    //in below code, we consider the illegal situation of m and n
    public static ListNode reverseBetween_ganker(ListNode head, int m, int n) {
    	if (head == null) {
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	int i = 1;
    	while (pre.next != null && i < m) {
    		pre = pre.next;
    		i++;
    	}
    	if (i < m) {
    		return head;
    	}
    	
    	ListNode mNode = pre.next;
    	ListNode cur = mNode.next;
    	
    	while (cur != null && i < n) {
    		ListNode temp = cur.next;
    		cur.next = pre.next;
    		pre.next = cur;
    		mNode.next = temp;
    		cur = temp;
    		i++;
    	}
    	return dummy.next;
    }

}
