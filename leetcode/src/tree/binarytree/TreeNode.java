package tree.binarytree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(){
		left = null;
		right = null;
	}
	
	public TreeNode(int x){
		val = x;
	}
	
	public TreeNode(int data, TreeNode leftNode, TreeNode rightNode){
		this.val = data;
		this.left = leftNode;
		this.right = rightNode;
	}
}