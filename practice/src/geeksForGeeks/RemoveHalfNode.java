package geeksForGeeks;

import global.TreeNode;

public class RemoveHalfNode {
	public static TreeNode removeHalfNode(TreeNode root){
		if(root.right!=null && root.left!=null){
			root.left = removeHalfNode(root.left);
			root.right = removeHalfNode(root.right);
		}
		else if(root.right==null && root.left!=null)
			root = removeHalfNode(root.left);
		else if(root.left==null && root.right!=null)
			root = removeHalfNode(root.right);
		
		return root;
	}
	
	public static void main(String[] args){
		TreeNode root = TreeNode.LeetcodeInitialize("(2,7,5,#,6,#,9,1,11,4,#)");
		TreeNode.levelOrder(removeHalfNode(root));
	}
}
