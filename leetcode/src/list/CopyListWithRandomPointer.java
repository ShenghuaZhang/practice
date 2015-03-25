package list;

import java.util.HashMap;
import java.util.Map;

/**
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
	/*
	 * Traverse two time, but using HashMap which need extra space O(n)
	 */
	public RandomListNode copyRandomListHashMap(RandomListNode head){
		if(head==null)  return head;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode current = head.next, newCurrent = newHead;
        
        while(current!=null){
            newCurrent.next = new RandomListNode(current.label);
            newCurrent = newCurrent.next;
            map.put(current, newCurrent);
            current = current.next;
        }
        
        current = head;
        newCurrent = newHead;
        while(current!=null){
            newCurrent.random = map.get(current.random);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        
        return newHead;
	}
	/*
	 * Traverse three times, but do not using extra space
	 */
	public RandomListNode copyRandomList(RandomListNode head){
		if(head==null)	return head;
		
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
//		while(current.next.next!=null){
//		    RandomListNode newNode = current.next;
//			current.next = current.next.next;
//			current = current.next;
//			newNode.next = newNode.next.next;
//		}
//		current.next = null;
		
		return newHead;
	}
}
