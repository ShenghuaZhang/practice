package tree.binarytree;


public class BalancedTree {
	public static boolean isBalanced(TreeNode root){
		return helper(root) >= 0;
	}
	
	public static int helper(TreeNode root){
		if (root == null) return 0;
		Integer left = helper(root.left), right = helper(root.right);
		if (left == -1 || right == -1) return -1;
		if (Math.abs(left-right) > 1) return -1;
		return (left>right?left:right) +1;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode();
		root.testRoot();
		System.out.print(isBalanced(root));
	 }
}
