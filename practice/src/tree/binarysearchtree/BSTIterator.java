package tree.binarysearchtree;
/**
 * 173
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time
 * and uses O(h) memory, where h is the height of the tree.
 * 
 */
import java.util.Stack;

import tree.binarytree.TreeNode;

public class BSTIterator {
	Stack<TreeNode>	stack;
	public BSTIterator(TreeNode root){
		stack = new Stack<>();
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public int next(){
		TreeNode node = stack.pop();
		int ret = node.val;
		node = node.right;
		while(node != null){
			stack.push(node);
			node = node.left;
		}
		return ret;
	}
}
