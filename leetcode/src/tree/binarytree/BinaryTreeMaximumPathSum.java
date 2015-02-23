package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {
	public static int maxPathSum(TreeNode root){
		List<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		helper(root, list);
		return list.get(0);
	}
	private static int helper(TreeNode root, List<Integer> list){
		if (root == null)	return 0;
		int left = helper(root.left, list),right = helper(root.right, list);
		left = left>0?left:0;
		right = right>0?right:0;
		int current = root.val + left + right;
		if (current > list.get(0)) list.set(0, current);
		return root.val + Math.max(left, right);
	}
	
	public static void main(String[] args){
		System.out.print(maxPathSum(TreeNode.LeetcodeInitialize("{2,-1,1,3,#,4,5,#,-5,6}")));
	}
}
