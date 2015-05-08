package tree.binarytree;

import java.util.Stack;

public class SymmetricTree {
	public boolean isSymmetricByRecursive(TreeNode root){
		if (root == null)	return true;
		return helper(root.left, root.right);
	}
	private boolean helper(TreeNode left, TreeNode right){
		if (left == null && right == null)	return true;
		if (left == null || right == null) 	return false;
		if (left.val != right.val)	return false;
		return helper(left.left, right.right) && helper(right.left, left.right);
	}
	
	// i love this one, Preorder and RightSide Preorder traversal at the same time
	public boolean isSymmetric(TreeNode root){
		if(root == null)	return true;
	    if(root.left == null && root.right == null)	return true;
	    if(root.left == null || root.right == null)	return false;
	    
	    TreeNode left = root.left, right = root.right;
	    Stack<TreeNode> ql = new Stack<>();
	    Stack<TreeNode> qr = new Stack<>();
	    
	    while((left!=null && right != null) || (!ql.isEmpty() && !qr.isEmpty())){
	    	while(left!=null && right!=null){
	    		if (left.val != right.val)	return false;
	    		ql.push(left);
	    		qr.push(right);
	    		left = left.left;
	    		right = right.right;
	    	}
	    	if (left == null && right == null){
	    		left = ql.pop().right;
	    		right = qr.pop().left;
	    	}else return false;
	    }
	    return (left == null)&&(right == null);
	}
}
