package tree.binarysearchtree;

import java.util.ArrayList;

import list.ListNode;
import tree.binarytree.Inorder;
import tree.binarytree.Levelorder;
import tree.binarytree.Postorder;
import tree.binarytree.Preorder;
import tree.binarytree.TreeNode;

public class SortedStructureToBST {
	public static TreeNode sortedArrayToBST(int[] Num){
		int length = Num.length;
		if (length == 0 || Num == null) return null;
		return sortedArrayToBSThelper(Num, 0, length-1);
	}
	private static TreeNode sortedArrayToBSThelper(int[] Num, int begin,
			int end) {
		if (begin > end) return null;
		
		TreeNode root = new TreeNode(Num[(begin + end)/2]);
		root.left = sortedArrayToBSThelper(Num, begin, (begin+end)/2-1);
		root.right = sortedArrayToBSThelper(Num, (begin+end)/2+1, end);
		return root;
	}
	
	public static TreeNode sortedListToBST(ListNode head){
		if (head == null) return null;
		int length = 0;
		ListNode current = head;
		while (current!= null){
			length ++;
			current = current.next;
		}
		
		ArrayList<ListNode> list = new ArrayList<>();
		list.add(head);
		return sortedListToBSThelper(list, 0, length-1);
	}
	private static TreeNode sortedListToBSThelper(ArrayList<ListNode> list, int begin, int end){
		if (begin > end) return null;
		int middle  = (begin+end)/2;
		TreeNode left = sortedListToBSThelper(list, begin, middle-1);
		TreeNode root = new TreeNode(list.get(0).val);
		list.set(0, list.get(0).next);
		root.left = left;
		root.right = sortedListToBSThelper(list, middle+1, end);
		return root;
	}
	
	public static void main(String[] args){
		TreeNode result = sortedListToBST(ListNode.initial().next);
		
		System.out.print("inorder:   " + Inorder.inorder(result));
		System.out.print("\npreorder:  " + Preorder.preorder(result));
		System.out.print("\npostorder: " + Postorder.postorder(result));
		System.out.print("\nlevelorder: " + Levelorder.levelorder(result));
	 }
}
