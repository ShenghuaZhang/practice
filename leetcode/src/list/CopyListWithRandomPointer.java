package list;

import java.util.HashMap;
import java.util.Map;

/**
 * 138
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * A linked list is given such that each node contains an
 * additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 * 
 * @author yili3
 *
 */
public class CopyListWithRandomPointer {
	/* Traverse one time, but using HashMap which need extra space O(n) */
	public RandomListNode copyRandomListHashMap(RandomListNode head){
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        while(current != null){
            if(!map.containsKey(current))
                map.put(current, new RandomListNode(current.label));
            if(current.next!=null){
                if(!map.containsKey(current.next))
                    map.put(current.next, new RandomListNode(current.next.label));
                map.get(current).next = map.get(current.next);
            }
            if(current.random!=null){
                if(!map.containsKey(current.random))
                    map.put(current.random, new RandomListNode(current.random.label));
                map.get(current).random = map.get(current.random);
            }
            current = current.next;
        }
        
        return map.get(head);
	}
	/* Traverse three times, not using hash map */
	public RandomListNode copyRandomList(RandomListNode head){
		RandomListNode current = head;
		
		while(current!=null){
			RandomListNode next = current.next;
			current.next = new RandomListNode(current.label);
			current.next.next= next;
			current = next;
		}
		
		current = head;
		while(current != null){
			if(current.random!=null)	current.next.random = current.random.next;
			current = current.next.next;
		}
		
		current = head;
		RandomListNode newHead = current.next;
		while(current!=null){
			RandomListNode temp = current.next;
			current.next = current.next.next;
			current = current.next;
			if(temp.next!=null)	temp.next = temp.next.next;
		}
		return newHead;
	}
}
