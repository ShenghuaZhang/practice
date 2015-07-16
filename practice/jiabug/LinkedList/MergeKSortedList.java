package LinkedList;


/**
 * 23
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author jiakangze
 *
 */
public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode mergeKLists(ListNode[] lists) {
    	if (lists == null || lists.length == 0) {
    		return null;
    	}
    	ListNode res = new ListNode(0);
    	ListNode helper = res;
        while (true) {
        	int localmin = Integer.MAX_VALUE;
        	int flag = -1;
        	for (int i = 0; i < lists.length; i++) {
        		if (lists[i] != null && lists[i].val <= localmin) {
        			localmin = lists[i].val;
        			flag = i;
        		}
        	}
        	if (flag >= 0 && lists[flag] != null) {
        		lists[flag] = lists[flag].next;
        	}
        	if (localmin == Integer.MAX_VALUE) {
        		break;
        	}
        	helper.next = new ListNode(localmin);
        	helper = helper.next;
        }
        helper.next = null;
        return res.next;
    }

}
