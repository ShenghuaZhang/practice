package list;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Write a program to find the node
 * at which the intersection of two singly linked lists begins.
 * @author yili3
 *
 */
public class IntersectionOfTwoLinkedLists {
	/*
	 * 1. Get count of the nodes in first list, let count be c1.
	 * 2. Get count of the nodes in second list, let count be c2.
	 * 3. Get the difference of counts d = Math.abs(c1 - c2)
	 * 4. Now traverse the bigger list from the first node till d nodes
	 * 	so that from here onwards both the lists have equal no of nodes.
	 * 5. Then we can traverse both the lists in parallel till we come across a common node.
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(!hasIntersection(headA, headB))	return null;
		
		int length1 = length(headA), length2 = length(headB);
		int length = Math.abs(length1-length2);
		if(length1>length2)	for(; length>0; length--)	headA = headA.next;
		else	for(; length>0; length--)	headB = headB.next;
		
		for(;headA!=headB; headA=headA.next,headB=headB.next);
		return headA;
	}
	
	/*
	 * 1. Traverse the first linked list(count the elements) and make a circular linked list.
	 * 	(Remember last node so that we can break the circle later on).
	 * 2. Now view the problem as find the loop in the second linked list. So the problem is solved.
	 * 3. Since we already know the length of the loop(size of first linked list)
	 * 	we can traverse those many number of nodes in second list,
	 * 	and then start another pointer from the beginning of second list.
	 * 	we have to traverse until they are equal, and that is the required intersection point.
	 * 4. remove the circle from the linked list.
	 */
	public static ListNode getIntersectionNodeII(ListNode headA, ListNode headB){
		if(!hasIntersection(headA, headB))	return null;
		ListNode last = headA, first=headB;
		
		int length=0;
		while(last!=null){
			length++;
			if(last.next==null){
				last.next = headA;
				break;
			}
			last=last.next;
		}
		while(length>0){
			first=first.next;
			length--;
		}
		while(headB!=first){
			headB=headB.next;
			first=first.next;
		}
		last.next=null;
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
	public static ListNode getIntersectionNodeIII(ListNode headA, ListNode headB){
		if(!hasIntersection(headA, headB))	return null;
		
		int length1 = 1, length2 = length(headB);
		ListNode last = headA;
		while(last.next!=null){
			length1++;
			last=last.next;
		}
		reverse(headA);

		int length3 = length(headB);
		int Y = (length2+length3-length1)/2;
		while(Y!=0){
			headB=headB.next;
			Y--;
		}
		reverse(last);
		return headB;
	}
	
	private static ListNode reverse(ListNode head){
		ListNode current = head, previous= null;
		while(current!=null){
			ListNode next =current.next;
			current.next=previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	private static int length(ListNode head){
		int length=0;
		while(head!=null){
			head = head.next;
			length++;
		}
		return length;
	}
	
	private static boolean hasIntersection(ListNode headA, ListNode headB){
		if(headA==null || headB==null)	return false;
		for(; headA.next!=null; headA=headA.next);
		for(; headB.next!=null; headB=headB.next);
		
		return headA==headB;
	}
}
