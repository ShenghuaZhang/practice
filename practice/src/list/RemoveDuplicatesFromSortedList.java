package list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * @author yili3
 *
 */

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current!=null&&current.next!=null){
            if(current.val==current.next.val)
            	current.next=current.next.next;
            else current = current.next;
        }
        return head;
    }
}
