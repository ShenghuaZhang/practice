package tree.binarytree;

import java.util.Stack;

public class BinaryTreePreOrder {
	public static void biTreePreOrderByRecursion(TreeNode root){
		if (root == null) return;
		
		System.out.println(root.val);
		biTreePreOrderByRecursion(root.left);
		biTreePreOrderByRecursion(root.right);
	}
	
	public static void biTreePreOrder(TreeNode root){
		if (root == null) return;
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (current != null || !stack.empty()){
			while (current != null){
				stack.push(current);
				System.out.println(current.val);
				current = current.left;
			}
			current = stack.pop();
			current = current.right;
		}
	}
}
