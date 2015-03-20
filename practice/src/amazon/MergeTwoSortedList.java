package amazon;

import global.*;

/**
 * 3.	Merge two sorted linked lists without using extra space
 * 
 * @author carllee1991
 *
 */
public class MergeTwoSortedList {
	public static ListNode mergeTwoSortedList(ListNode first, ListNode second){
		if(first==null && second==null)	return null;
		if(first==null && second!=null)	return second;
		if(first!=null && second==null)	return first;
		if(first.val > second.val)	return mergeTwoSortedList(second, first);
		
		
		ListNode current1 =first, next1= current1.next, current2=second, next2=current2.next;
		while(next1!=null && next1.val<current2.val){
			current1=next1;
			next1=next1.next;
		}
		current1.next=current2;
		if(next1==null)	return first;
		
		while(next1!=null && current2!=null){
			if(next1.val>current2.val){
				while(next2!=null && next2.val<next1.val){
					current2= next2;
					next2=current2.next;
				}
				current2.next=next1;
				current1=next1;
				next1=current1.next;
			}
		}
		return first;
	}
	
	public static void main(String[] args){
		ListNode first = ListNode.initial(), second = ListNode.LeetcodeInitialize("(1,2,3,4,5,6,7,8,9)");
		ListNode rs = mergeTwoSortedList(first, second);
		ListNode.print(rs);
	}
}
