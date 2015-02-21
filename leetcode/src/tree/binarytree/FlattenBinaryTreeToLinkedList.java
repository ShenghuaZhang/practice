package tree.binarytree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	public static void flatten(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
	    TreeNode temp = root;
	    
	    while(temp != null ||!stack.isEmpty()){
	    	if (temp.right != null)	stack.push(temp.right);
	    	
	    	if (temp.left != null){
	    		temp.right = temp.left;
	    		temp.left = null;
	    	}else if (!stack.isEmpty()){
	    		temp.right = stack.pop();
	    	}

		    temp = temp.right;
	    }
	}
	
	public static void main(String[] args){
		flatten(TreeNode.LeetcodeInitialize("{1,2}"));
	}
}
