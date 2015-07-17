package LinkedList;

/**
 * 25
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author jiakangze
 *
 * #SwapNodesInPairs
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode reverseKGroup_my(ListNode head, int k) {
    	if (head == null) {
    		return null;
    	}
    	
        ListNode node = head;
        int length = 0;
        while (node != null) {
        	length++;
        	node = node.next;
        }
        
        if (k > length) {
        	return head;
        }
        
        int round = length / k;
        
        ListNode newhead = new ListNode(0);
        ListNode cur = head.next;
        ListNode pre = head;
        
        for (int i = 0; i < round; i++) {
        	int ktemp = k;
        	while (ktemp > 1) {
        		ListNode temp = cur.next;
        		cur.next = pre;
        		pre = cur;
        		cur = temp;
        		ktemp--;
        	}
        	if (i == 0) {
        		newhead.next = pre;
        	} else {
        		head.next = pre;
        		for (int j = 0; j < k; j++) {
        			head = head.next;
        		}
        	}
        	pre = cur;
        	if (cur == null) {
        		break;
        	}
        	cur = cur.next;
        }
        head.next = pre;
        
        return newhead.next;
    }
    
    public static ListNode reverseKGroup_ganker(ListNode head, int k) {
    	
    	ListNode helper = new ListNode(0);
    	helper.next = head;
    	ListNode cur = head;
    	ListNode pre = helper;
    	int count = 0;
    	while (cur != null) {
    		ListNode next = cur.next;
    		count++;
    		if (count == k) {
    			pre = reverse(pre,next);
    			count = 0;
    		}
    		cur = next;
    	}
    	return helper.next;
    }
    
    private static ListNode reverse(ListNode pre, ListNode end) {
    	ListNode head = pre.next;
    	ListNode cur = pre.next.next;
    	while (cur != end) {
    		ListNode temp = cur.next;
    		cur.next = pre.next;
    		pre.next = cur;
    		cur = temp;
    	}
    	head.next = cur;
    	return head;
    }
    
    private static ListNode reverse_yi(ListNode pre, ListNode end) {
    	ListNode cur = pre.next;
    	while (cur.next != null) {
    		ListNode temp = cur.next;
    		cur.next = temp.next;
    		temp.next = pre.next;
    		pre.next = temp;
    	}
    	return cur;
    }

}
