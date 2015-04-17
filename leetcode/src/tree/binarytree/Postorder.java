package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder {
	public static List<Integer> postorder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)	return list;
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode current = stack.peek();
			if (current.right==null && current.left==null) {
				list.add(current.val);
				stack.pop();
				while (!stack.empty()
						&& (stack.peek().right==current || stack.peek().left==current)) {
					current = stack.pop();
					list.add(current.val);
				}
			} else {
				if (current.right != null)
					stack.push(current.right);
				if (current.left != null)
					stack.push(current.left);
			}
		}

		return list;
	}

	// best logical one
	public List<Integer> postorderII(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		if (current == null)
			return list;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
			current = stack.pop();
			if (current.right != null) {
				stack.add(new TreeNode(current.val));
				current = current.right;
			} else {
				list.add(current.val);
				current = null;
			}
		}

		return list;
	}

	// recursive
	public List<Integer> postorderRecursion(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		helper(list, root);
		return list;
	}

	private void helper(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		helper(list, root.left);
		helper(list, root.right);
		list.add(root.val);
	}

	public List<Integer> postorderRecursionII(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root != null) {
			list.addAll(postorderRecursionII(root.left));
			list.addAll(postorderRecursionII(root.right));
			list.add(root.val);
		}
		return list;
	}
}
