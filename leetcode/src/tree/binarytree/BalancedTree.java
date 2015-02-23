package tree.binarytree;


public class BalancedTree {
	public static boolean isBalanced(TreeNode root){
		return helper(root) >= 0;
	}
	private static int helper(TreeNode root){
		if (root == null) return 0;
		int left = helper(root.left);
		if (left == -1) return -1;
		int right = helper(root.right);
		if (right == -1) return -1;
		if (Math.abs(left-right) > 1) return -1;
		return (left>right?left:right) +1;
	}
	
	public static void main(String[] args){
		System.out.print(isBalanced(TreeNode.testRoot()));
	 }
}
