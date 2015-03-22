package list;
/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author yili3
 *
 */
public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				p.next = l1;
				l1 = l1.next;
			}else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1!=null)	p.next = l1;
		if(l2!=null)	p.next = l2;
		return dummyHead.next;
	}

	public static ListNode mergeTwoListsMine(ListNode l1, ListNode l2){
		if(l1==null && l2!=null)	return l2;
		if(l1!=null && l2==null)	return l1;
		if(l1==null && l2==null)	return null;
		if(l1.val > l2.val)	return mergeTwoListsMine(l2, l1);
		
		ListNode cur1=l1, cur2=l2, next1=cur1.next, next2=cur2.next;
		while(next1!=null){
			 if(next1.val<=cur2.val){
				 cur1=next1;
				 next1=cur1.next;
			 }else{
				 cur1.next = cur2;
				 while(next2!=null && next2.val<=next1.val){
					 cur2=next2;
					 next2=cur2.next;
				}
				cur2.next = next1;
				cur1=next1;
				next1=cur1.next;
				if(next2!=null){
					cur2=next2;
					next2=cur2.next;
				}else return l1;
			}
		}
		if(next1==null) cur1.next=cur2;
		return l1;
	}
	
	public static void main(String[] args) {
		ListNode l1 = ListNode
				.LeetcodeInitialize("{-1,-1,0,1,28,29,29}");
		ListNode l2 = ListNode
				.LeetcodeInitialize("{-1,-1,0,0,28,29,29}");
		ListNode head = mergeTwoLists(l1, l2);
		ListNode.print(head);
	}
}
