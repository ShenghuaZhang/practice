package LinkedList;

import java.util.HashMap;

/**
 * 138
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * @author kajia
 * 
 * http://stackoverflow.com/questions/6182565/deep-copy-shallow-copy-clone
 */

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		
	}
	/* Traverse two times, but using HashMap which need extra space O(n) */
    public static RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) {
    		return null;
    	}
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newhead = new RandomListNode(head.label);
        map.put(head, newhead);
        RandomListNode pre = newhead;
        RandomListNode cur = head.next;
        while (cur != null) {
        	RandomListNode temp = new RandomListNode(cur.label);
        	map.put(cur, temp);
        	pre.next = temp;
        	pre = pre.next;
        	cur = cur.next;
        }
        while (head != null) {
        	map.get(head).random = map.get(head.random);
        	head = head.next;
        }
        return newhead;
    }
    
    public static RandomListNode copyRandomList_good(RandomListNode head) {
    	if (head == null) {
    		return null;
    	}
    	
    	RandomListNode cur = head;
    	
    	while (cur != null) {
    		RandomListNode temp = new RandomListNode(cur.label);
    		temp.next = cur.next;
    		cur.next = temp;
    		cur = cur.next.next;
    	}
    	
    	cur = head;
    	//RandomListNode cur2 = head.next;//we do not need cur2
    	while (cur != null) {
    		if (cur.random != null) {
    			cur.next.random = cur.random.next;
    		}// do not need to write if (pre.random == null) cur2.random = null; else cur2.random = pre.random.next;
    		cur = cur.next.next;
    	}
    	
    	/*
    	 while (pre != null) {
    		if (pre.random != null) {
    			cur2.random = pre.random.next;
    		}
    		pre = pre.next.next;
    		if (pre != null) {
    			cur2 = pre.next;	
    		}
    	}
    	 */
    	//we also should preserve the old list!!!!!!!!
    	RandomListNode newhead = head.next;
    	cur = head;
    	while (cur != null) {
    		RandomListNode temp = cur.next.next;
    		if (temp != null) {
    			cur.next.next = temp.next;
    		}// do not need else cur.next.next = null;
    		cur.next = temp;
    		cur = temp;
    	}
    	
    	return newhead;
    }

}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
