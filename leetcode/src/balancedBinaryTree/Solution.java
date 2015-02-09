package balancedBinaryTree;

import tree.binarytree.BiTreeNode;

public class Solution {
	public static boolean isBalanced(BiTreeNode root){
		return helper(root) >= 0;
	}
	
	public static int helper(BiTreeNode root){
		if (root == null) return 0;
		Integer left = helper(root.leftNode), right = helper(root.rightNode);
		if (left == -1 || right == -1) return -1;
		if (Math.abs(left-right) > 1) return -1;
		return (left>right?left:right) +1;
	}
	
	public static void main(String[] args){
		BiTreeNode root = new BiTreeNode(1, null, null), left = new BiTreeNode(2, null, null), right = new BiTreeNode(3, null, null);
		root.leftNode = left;
		root.leftNode.leftNode = right;
		 System.out.print(isBalanced(root));
	 }
}
