package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import tree.binarytree.TreeNode;

public class UniqueBinarySearchTrees {
	public int numTrees(int n){
		if (n <= 0)	return 0;
		int[] res = new int[n+1];
		res[0] = 1; res[1] = 1;
		
		for (int i = 2; i <= n; i++)
			for (int j = 0; j < i; j++)
				res[i] += res[j] * res[i-j-1];
		
		return res[n];
	}
	
	public List<TreeNode> generateTrees(int n){
		return helper(1, n);
	}
	private List<TreeNode> helper(int left, int right){
		List<TreeNode> res = new ArrayList<>();
		if (left > right){
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++){
			List<TreeNode> leftList = helper(left, i-1);
			List<TreeNode> rightList = helper(i+1, right);
			for (int j=0; j < leftList.size(); j++){
				for (int k=0; k < rightList.size(); k++){
					TreeNode root = new TreeNode(i);
					root.left = leftList.get(j);
					root.right = rightList.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
}
