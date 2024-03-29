package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
	public List<Integer> preorderRecursion(TreeNode root){
		return helper(new ArrayList<Integer>(), root);
	}
	private List<Integer> helper(List<Integer> list, TreeNode root){
		if (root == null) return list;
		list.add(root.val);
		helper(list, root.left);
		helper(list, root.right);
		return list;
	}
	
	public static List<Integer> preorder(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		
		if (current == null) return list;
		
		while (current != null || !stack.empty()){
			while (current != null){
				stack.push(current);
				list.add(current.val);
				current = current.left;
			}
			current = stack.pop();
			current = current.right;
		}
		
		return list;
	}
}

