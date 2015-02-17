package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.TreeNode;

public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root){
		if (root == null)	return true;
		Stack<TreeNode> stack = new Stack<>();
		int cnt = 0, max = 0;
		while(root!= null || !stack.isEmpty()){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(cnt == 0){
				cnt ++;
				max = root.val;
			}else {
				if(max >= root.val)	return false;
				max = root.val;
			}
			root = root.right;
		}
		return true;
	}
	
	public boolean isValidBSTbyRecursive(TreeNode root){
		List<Integer> list = new ArrayList<>();
		list.add(null);
		return helperRecursive(list, root);
	}
	private boolean helperRecursive(List<Integer> list, TreeNode root){
		if (root == null) return true;
		boolean left = helperRecursive(list, root.left);
		if (list.get(0) != null && root.val <= list.get(0))	return false;
		list.set(0, root.val);
		return left && helperRecursive(list, root.right);
	}

//	This is not a good solution because of the answer have a bug when the minimum in the tree is -2147483647 and
//	max is 2147483647
//	public boolean isValidBSTbyTrick(TreeNode root){
//		return helperTrick(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
//	}
//	private boolean helperTrick(TreeNode root, int max, int min){
//		if(root == null) return true;
//		if (root.val <= min || root.val >= max) return false;
//		return helperTrick(root.left, root.val, min) && helperTrick(root.right, max, root.val);
//	}
}
