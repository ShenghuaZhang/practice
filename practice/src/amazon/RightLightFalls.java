package amazon;

import global.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *	TODO: first two method is wrong answer
 * Round 3: (F2F - Data structures and Algorithms)
 * 2. Give a binary tree and a light source fixed placed right side of the tree.
 * Print all the nodes where the light directly falls.
 * 
 * @author carllee1991
 *
 */

public class RightLightFalls {
	/*
	 * This algorithm is very fast when we know the height of tree
	 */
	public static void printRightMostNode(TreeNode root){
		int height = SpiralOrderBTree.height(root);
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		int finished = 0, curHeight = 1;
		
		while(current!=null || height>finished){
			while(current!=null){
				if(curHeight>finished){
					finished++;
					System.out.println(finished+": "+current.val);
				}
				stack.push(current);
				current = current.right;
				curHeight++;
			}
			current = stack.pop();
			curHeight--;
			if(current.left!=null){
				current=current.left;
				curHeight++;
			}
			else current = null;
		}
	}
	
	public static void printLeftMostNode(TreeNode root){
		int height = SpiralOrderBTree.height(root);
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		int finished = 0, curHeight = 1;
		
		while(current!=null || height>finished){
			while(current!=null){
				if(curHeight>finished){
					finished++;
					System.out.println(finished+": "+current.val);
				}
				stack.push(current);
				current = current.left;
				curHeight++;
			}
			current = stack.pop();
			curHeight--;
			if(current.right!=null){
				current=current.right;
				curHeight++;
			}
			else current = null;
		}
	}
	
	public static void printRightMostNodeLevelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode current = root;
		queue.add(current);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				current = queue.poll();
				if(i==size-1)	System.out.println(current.val);
				if(current.left!=null)	queue.add(current.left);
				if(current.right!=null)	queue.add(current.right);
			}
		}
	}
	
	public static void main(String[] args){
		TreeNode root = TreeNode.LeetcodeInitialize("{4,3,6,1,#,5,#,#,2}");
		printLeftMostNode(root);
		printRightMostNodeLevelOrder(root);
	}
}
