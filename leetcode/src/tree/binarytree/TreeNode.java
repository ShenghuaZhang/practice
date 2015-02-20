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
	
	public static TreeNode testRoot(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		return root;
	}
	
	public static void initialize(TreeNode root){
		root = new TreeNode(15);
		root.left = new TreeNode(22);
		root.right = new TreeNode(28);
		root.left.left = new TreeNode(11);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(-6);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
	}
	
}