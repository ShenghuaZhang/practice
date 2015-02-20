package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum){
		if (root == null)	return false;
		if (root.left == null && root.right == null && root.val == sum)	return true;
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>>	list = new ArrayList<>();
		if (root == null)	return list;
		
		List<Integer> currentList = new ArrayList<>();
		currentList.add(root.val);
		helper(root, sum-root.val, list, currentList);
		return list;
	}
	private static void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> currentList){
		if (root == null)	return;
		if (root.left == null && root.right == null && sum == 0){
			list.add(new ArrayList<Integer>(currentList));
			return;
		}
		if (root.left != null){
			currentList.add(root.left.val);
			helper(root.left, sum-root.left.val, list, currentList);
			currentList.remove(currentList.size()-1);
		}
		if (root.right != null){
			currentList.add(root.right.val);
			helper(root.right, sum-root.right.val, list, currentList);
			currentList.remove(currentList.size()-1);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = TreeNode.testRoot();
		System.out.print(hasPathSum(root, 8)?pathSum(root, 8):"Do not has this path.");
	}
}
