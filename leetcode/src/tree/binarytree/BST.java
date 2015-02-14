package tree.binarytree;

import java.util.ArrayList;
import list.ListNode;

public class BST {
	public static TreeNode sortedArrayToBST(int[] Num){
		int length = Num.length;
		if (length == 0 || Num == null) return null;
		return sortedArrayToBSThelper(Num, 0, length-1);
	}
	private static TreeNode sortedArrayToBSThelper(int[] Num, int begin,
			int end) {
		if (begin > end) return null;
		
		TreeNode root = new TreeNode(Num[(begin + end)/2]);
		InOrder.inOrder(root);
		root.left = sortedArrayToBSThelper(Num, begin, (begin+end)/2-1);
		root.right = sortedArrayToBSThelper(Num, (begin+end)/2+1, end);
		return root;
	}
	
	public static TreeNode sortedListToBST(ListNode head){
		if (head == null) return null;
		int length = 0;
		while (head!= null){
			length ++;
			head = head.next;
		}
		
		ArrayList<ListNode> list = new ArrayList<>();
		list.add(head);
		return sortedListToBSThelper(list, 0, length-1);
	}
	private static TreeNode sortedListToBSThelper(ArrayList<ListNode> list, int begin, int end){
		return new TreeNode(list.get(0).val);
	}
}
