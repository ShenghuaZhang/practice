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
		if (head == null) {
			return null;
		}
		
		//we leave the big part in the origin position. and insert the small ones after the lastsmall
		ListNode helper = new ListNode(0);
		ListNode lastSmall = helper;
		helper.next = head;
		
		ListNode cur = head;
		ListNode lastBig = null;
		
		while (cur != null) {
			if (cur.val >= x) {
				lastBig = cur;
				cur = cur.next;
			} else if (lastBig == null) {
				lastSmall = cur;
				cur = cur.next;
			} else {
				lastBig.next = cur.next;
				cur.next = lastSmall.next;//using this to connect the small part and big part
				lastSmall.next = cur;
				lastSmall = cur;
				cur = lastBig.next;
			}
		}
		return helper.next;
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
