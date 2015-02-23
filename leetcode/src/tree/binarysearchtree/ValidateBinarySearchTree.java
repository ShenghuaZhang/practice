package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.TreeNode;

public class ValidateBinarySearchTree {
	/************************** 0 **************************/
	// Using InOrder Traversal, but we do not use recursive here but using stack instead.
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
	/************************** 1 **************************/
	// Using the requirement we define a low and high value for each node, if not satisfy return false.
	public boolean isValidBSTClean(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer low, Integer high){
        if (root == null)   return true;
        return (low==null || root.val>low) && (high==null || root.val<high) 
        		&& helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
    /************************** 2 **************************/
    // Using InOrder Traversal, next node's value should bigger than the previous one.
    TreeNode previous;
    public boolean isValidBSTInOrder(TreeNode root) {
        previous = null;
        return helper(root);
    }
    private boolean helper(TreeNode root){
        if (root==null) return true;
        if (helper(root.left)){
            if (previous == null || previous.val < root.val)   previous = root;
            else return false;
            return helper(root.right);
        }
        return false;
    }
    /************************** 3 **************************/
    // Same with 2, only difference is here we use a list to save previous node value on InOrder Traversal.
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
}
