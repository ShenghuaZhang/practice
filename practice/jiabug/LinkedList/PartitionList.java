package LinkedList;

/**
 * 86
 * https://leetcode.com/problems/partition-list/
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author jiakangze
 *
 */

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ListNode partition(ListNode head, int x) {
		ListNode pre1 = new ListNode(0);
		ListNode cur1 = head;
		
		ListNode head2 = new ListNode(0);
		ListNode cur2 = head2;
		
		while (cur1 != null) {
			ListNode temp = cur1.next;
			if (cur1.val >= x) {
				cur2.next = cur1;
				cur2 = cur2.next;
				cur2.next = null;
				cur1 = temp;
			}
			
		}
	}
	
	
    public static ListNode partition_cc(ListNode head, int x) {
        ListNode smallpre = new ListNode(0);
        ListNode smallafter = smallpre;
        ListNode bigpre = new ListNode(0);
        ListNode bigafter = bigpre;
        
        while (head != null) {
        	ListNode temp = head.next;
        	head.next = null;
        	if (head.val < x) {
        		smallafter.next = head;
        		smallafter = smallafter.next;
        	} else {
        		bigafter.next = head;
        		bigafter = bigafter.next;
        	}
        	head = temp;
        }
        if (smallpre.next == null) {
        	return bigpre.next;
        }
        
        smallafter.next = bigpre.next;
        return smallpre.next;
        
    }

}
