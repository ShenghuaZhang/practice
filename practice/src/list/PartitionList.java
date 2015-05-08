package list;
/**
 * https://leetcode.com/problems/partition-list/
 * 
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author yili3
 *
 */
public class PartitionList {
	public static ListNode partitionMine(ListNode head, int x){
		if(head==null)	return head;
		
		ListNode dummyHead = new ListNode(0), lastSmall=dummyHead;
		dummyHead.next = head;
		
		ListNode current = head, lastBig=null;
		while(current!=null){
			if(current.val>=x){
				lastBig = current;
				current=lastBig.next;
			}
			else if(lastBig==null){
				lastSmall=current;
				current=lastSmall.next;
			}else{
				lastBig.next = current.next;
				current.next = lastSmall.next;
				lastSmall.next = current;
				lastSmall = current;
				current = lastBig.next;
			}
		}
		
		return dummyHead.next;
	}
}
