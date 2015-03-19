package amazon;

/**
 * Round 3: (F2F - Data structures and Algorithms)
 * 1. Give a binary tree, print all the nodes in spiral order with constant space
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.LevelOrder;
import tree.binarytree.TreeNode;

public class SpiralOrderBTree{
	public static List<List<Integer>> spiralOrder(TreeNode root) {
		Stack<TreeNode> oddStack = new Stack<>();
		Stack<TreeNode> evenStack = new Stack<>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)	return list;
		oddStack.add(root);
		
		while (!oddStack.empty() || !evenStack.empty()) {
			List<Integer> oddList = new ArrayList<>(), evenList = new ArrayList<>();
			while(!oddStack.empty()){
				TreeNode current = oddStack.pop();
				oddList.add(current.val);
				if (current.left != null)	evenStack.push(current.left);
				if (current.right != null)	evenStack.push(current.right);
			}
			
			while(!evenStack.empty()){
				TreeNode current = evenStack.pop();
				evenList.add(current.val);
				if (current.right != null)	oddStack.push(current.right);
				if (current.left != null)	oddStack.push(current.left);
			}
			
			list.add(oddList);
			list.add(evenList);
		}

		return list;
	}
	
	/** Just printed out use constant space */
	public static /* <List<List<Integer>> */void spiralOrderRecursive(TreeNode root){
//		List<List<Integer>> list = new ArrayList<>();
		int height = height(root);
		for(int i=1; i<=height; i++){
//			List<Integer> curList= new ArrayList<>();
			helper(root, i, /*curList, */(i%2==1));
//			list.add(curList);
		}
//		return list;
	}
	private static void helper(TreeNode root, int height,/* List<Integer> curList, */boolean order){
		if(root == null)	return;
		
//		if(height==1)	curList.add(root.val);
		if(height==1)	System.out.print(root.val+" ");
		else if(order){
			helper(root.left, height-1,/* curList, */order);
			helper(root.right, height-1,/* curList, */order);
		}else{
			helper(root.right, height-1,/* curList, */order);
			helper(root.left, height-1,/* curList, */order);
		}
	}
	protected static int height(TreeNode root){
		if(root==null)	return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	public static void main(String[] args){
		TreeNode root = TreeNode.LeetcodeInitialize("(4,3,2,5,61,2,0,6,13,9,7,8)");
		System.out.println("Original: "+LevelOrder.levelOrder(root));
//		System.out.println("Recursive: "+spiralOrderRecursive(root));
		spiralOrderRecursive(root);
		System.out.println();
		System.out.print("Iterative: "+spiralOrder(root));
	}
}
