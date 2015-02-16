package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

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
	
	public boolean isSymmetric(TreeNode root){
		if(root == null)	return true;
	    if(root.left == null && root.right == null)	return true;
	    if(root.left == null || root.right == null)	return false;
	    
	    TreeNode left = root.left, right = root.right;
	    Queue<TreeNode> ql = new LinkedList<>();
	    Queue<TreeNode> qr = new LinkedList<>();
	    
	    while((left!=null && right != null) || (!ql.isEmpty() && !qr.isEmpty())){
	    	while(left!=null && right!=null){
	    		if (left.val != right.val)	return false;
	    		ql.add(left);
	    		qr.add(right);
	    		left = left.left;
	    		right = right.right;
	    	}
	    	if (left == null && right == null){
	    		left = ql.poll().right;
	    		right = qr.poll().left;
	    	}else return false;
	    }
	    return (left == null)&&(right == null);
	}
}
