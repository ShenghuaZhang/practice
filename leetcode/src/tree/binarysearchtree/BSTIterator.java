package tree.binarysearchtree;

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
		if (node.right != null){
			node = node.right;
			while(node != null){
				stack.push(node);
				node = node.left;
			}
		}
		return ret;
	}
}
