package LinkedList;


/**
 * 237
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 * @author jiakangze
 *
 */

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//we do not know the previous value of listnode, so just can copy the value of next listnode to current node.
	public static void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}
}
