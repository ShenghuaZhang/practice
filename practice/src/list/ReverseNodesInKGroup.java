package list;

/**
 * 25
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * For example,
 * Given this linked list: 			1->2->3->4->5
 * For k = 2, you should return: 	2->1->4->3->5
 * For k = 3, you should return: 	3->2->1->4->5
 * 
 * Only constant memory is allowed.
 * 
 * @author yili3
 *
 */

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0), current=head, previous = dummyHead;
        dummyHead.next = head;
        int cnt = 0;
        while(current!=null){
            cnt ++;
            ListNode next = current.next;
            if(cnt == k){
                previous = reverseK(previous, next);
                cnt = 0;
            }
            current=next;
        }
        return dummyHead.next;
    }
    private ListNode reverseK(ListNode previous, ListNode end){
        ListNode current = previous.next;
        while(current.next!=end){
            ListNode next = current.next;
            current.next = next.next;
            next.next = previous.next;
            previous.next = next;
        }
        return current;
    }
}
