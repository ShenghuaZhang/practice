package list;
/**
 * 203
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @author carllee1991
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val)    head=head.next;
        if(head==null)  return head;
        ListNode previous = head, current = previous.next;
        while(current!=null){
            ListNode next = current.next;
            if(current.val==val)    previous.next = next;
            else    previous = current;
            current = next;
        }
        return head;
    }
}
