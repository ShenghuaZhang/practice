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
        ListNode dummyHead = head;
        while(dummyHead!=null&&dummyHead.next!=null){
            if(dummyHead.val==dummyHead.next.val)
                dummyHead.next=dummyHead.next.next;
            else dummyHead = dummyHead.next;
        }
        return head;
    }
}
