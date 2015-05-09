package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.TreeNode;
/**
 * 98
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * @author carllee1991
 *
 */
public class ValidateBinarySearchTree {
	/************************** 0 **************************/
	// Using InOrder Traversal, but we do not use recursive here but using stack instead.
	public static boolean isValidBST(TreeNode root){
		if (root == null)   return true;
        Integer previous = null;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            
            if (previous == null || previous < current.val)
            	previous = current.val;
            else return false;
            
            current = current.right;
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
