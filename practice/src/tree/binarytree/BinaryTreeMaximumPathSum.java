package tree.binarytree;
/**
 * 124
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *    1
 *   / \
 *  2   3
 *  Return 6.
 */
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root){
		if(root==null)	return 0;
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		helper(root, list);
		return list.get(0);
	}
	private int helper(TreeNode root, List<Integer> list){
		if (root == null)	return 0;
		int left = helper(root.left, list),right = helper(root.right, list);
		left = left>0?left:0;
		right = right>0?right:0;
		int current = root.val + left + right;
		if (current > list.get(0)) list.set(0, current);
		return root.val + Math.max(left, right);
	}
}
