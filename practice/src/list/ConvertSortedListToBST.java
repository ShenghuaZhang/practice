package list;

import java.util.ArrayList;
import java.util.List;

import tree.binarytree.*;
/**
 * 109
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * @author yili3
 *
 */
public class ConvertSortedListToBST {
	public static TreeNode sortedListToBST(ListNode head){
		if(head==null)	return null;
		ListNode cur = head;
		int length=0;
		while(cur!=null){
			length++;
			cur = cur.next;
		}
		List<ListNode> list= new ArrayList<>();
		list.add(head);
		
		return helper(list, 0, length-1);
	}
	private static TreeNode helper(List<ListNode> list, int start, int end){
		if(start>end)	return null;
		int middle = (start+end)/2;
		TreeNode left = helper(list, start, middle-1);
		TreeNode root = new TreeNode(list.get(0).val);
		root.left= left;
		list.set(0,  list.get(0).next);
		root.right= helper(list, middle+1, end);
		return root;
	}
	
	public static void main(String[] args){
		TreeNode root = sortedListToBST(ListNode.initial());
		TreeNode.levelOrder(root);
	}
}
