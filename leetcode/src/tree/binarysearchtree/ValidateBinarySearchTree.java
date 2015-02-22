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
	
	public boolean isValidBSTClean(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer low, Integer high){
        if (root == null)   return true;
        return (low==null || root.val>low) && (high==null || root.val<high) && helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
