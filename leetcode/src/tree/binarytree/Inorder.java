package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
	public static List<Integer> inorderRecursion(TreeNode root){
		List<Integer> list = new ArrayList<>();
		helper(list, root);
		return list;
	}
	private static void helper(List<Integer> list, TreeNode root){
		if (root == null) return;
		helper(list, root.left);
		list.add(root.val);
		helper(list, root.right);
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;

		list.addAll(inorderTraversal(root.left));
		list.add(root.val);
		list.addAll(inorderTraversal(root.right));

		return list;
	}
	
	public static List<Integer> inorder(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		if (root == null) return list;
		
		while (current != null || !stack.isEmpty()){
			while (current != null){
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			list.add(current.val);
			current = current.right;
		}
		
		return list;
	}
}
