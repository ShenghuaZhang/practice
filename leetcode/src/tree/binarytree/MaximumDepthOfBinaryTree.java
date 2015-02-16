package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	public int maximumDepthByRecursive(TreeNode root){
		if (root == null)	return 0;
		return 1+Math.max(maximumDepthByRecursive(root.left), maximumDepthByRecursive(root.right));
	}
	
	public int maximumDepth(TreeNode root){
		if (root == null)	return 0;
		int levelCnt = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int j = 0; j < size; j++){
				TreeNode current = queue.poll();
				if (current.left != null)	queue.add(current.left);
				if (current.right != null) 	queue.add(current.right);
			}
			levelCnt++;
		}
		
		return levelCnt;
	}
}
