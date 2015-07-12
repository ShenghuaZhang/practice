package LinkedList;

/**
 * 160
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗   
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author kajia
 *
 */

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (!hasIntersection(headA, headB)) {//if the two last nodes are not same, they must not have intersection.
        	return null;
        }
        int length1 = length(headA);
        int length2 = length(headB);
        
        int gap = Math.abs(length1 - length2);
        if (length1 > length2) {
        	while (gap != 0) {
        		headA = headA.next;
        		gap--;
        	}
        } else {
        	while (gap != 0) {
        		headB = headB.next;
        		gap--;
        	}
        }
        for (;headA != headB; headA = headA.next, headB = headB.next);
        return headA;
        
    }
    private static int length (ListNode node) {
    	int count = 0;
    	while (node != null) {
    		node = node.next;
    		count++;
    	}
    	return count;
    }
    private static boolean hasIntersection (ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
    		return false;
    	}
    	for (;headA.next != null; headA = headA.next);
    	for (;headB.next != null; headB = headB.next);
    	return true;
    }

}
