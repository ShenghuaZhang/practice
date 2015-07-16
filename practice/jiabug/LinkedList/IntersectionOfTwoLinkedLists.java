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
	
    public static ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
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
    
    /*
	 * 1. Traverse the first linked list(count the elements) and make a circular linked list.
	 * 	(Remember last node so that we can break the circle later on).
	 * 2. Now view the problem as find the loop in the second linked list.
	 * 	So the problem is solved.
	 * 3. Since we already know the length of the loop(size of first linked list)
	 * 	we can traverse those many number of nodes in second list,
	 * 	and then start another pointer from the beginning of second list.
	 * 	we have to traverse until they are equal, and that is the required intersection point.
	 * 4. remove the circle from the linked list.
	 */
    public static ListNode getIntersectionNodeII(ListNode headA, ListNode headB) {
    	if (!hasIntersection(headA, headB)) {
    		return null;
    	}
    	
    	ListNode last = headA;
    	ListNode first = headB;
    	
    	int length = 1;
    	while (last.next != null) {
    		last = last.next;
    		length++;
    	}
    	last.next = headA;
    	
    	
    	//B goes through the distance of |b-a|, then A and B will begin at the same line.
    	while (length > 0) {//do not contain 0
    		first = first.next;
    		length--;
    	}
    	
    	while (first != headB) {
    		first = first.next;
    		headB = headB.next;
    	}
    	
    	last.next = null;
    	
    	return first;
    }
    
    /*
	 * 1) Let X be the length of the first linked list until intersection point.
	 * Let Y be the length of the second linked list until the intersection point.
	 * Let Z be the length of the linked list from intersection point to End of
	 * the linked list including the intersection node.
	 * We Have:
	 * 				X + Z = length1;
	 * 				Y + Z = length2;
	 * 2) Reverse first linked list.
	 * 3) Traverse Second linked list. Let C3 be the length of second list - 1. 
	 * Now we have
	 * 				X + Y = length3
	 * We have 3 linear equations. By solving them, we get
	 * 			X = (length1 + length3 - length2)/2;
	 * 			Y = (length2 + length3 - length1)/2;
	 * 			Z = (length1 + length2 - length3)/2;
	 * WE GOT THE INTERSECTION POINT.
	 * 4)  Reverse first linked list.
	 * 
	 * Advantage: No Comparison of pointers.
	 * Disadvantage : Modifying linked list(Reversing list).
	 */
    public static ListNode getIntersectionNodeIII(ListNode headA, ListNode headB) {
    	if (!hasIntersection(headA, headB)) {
    		return null;
    	}
    	int length1 = length(headA);
    	int length2 = length(headB);
    	ListNode reverseHeadA = reverse(headA);
    	int length3 = length(headB) - 1;
    	
    	int Y = (length2 + length3 - length1) / 2;
    	//length2 + length3  - length1 - 1 is even. so when we add 1, the result won't change
    	while(Y > 0) {
    		headB = headB.next;
    		Y--;
    	}
    	headA = reverse(reverseHeadA);
    	return headB;
    }
    
    private static ListNode reverse (ListNode node) { 
    	ListNode pre = null;
    	while (node != null) {
    		ListNode temp = node.next;
    		node.next = pre;
    		pre = node;
    		node = temp;
    	}
    	return pre;
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
    	return headA == headB;//we compare the physical address directly.
    }

}
