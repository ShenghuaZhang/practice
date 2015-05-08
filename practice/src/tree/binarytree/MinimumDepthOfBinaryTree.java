package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	public int minDepthByRecursive(TreeNode root) {
		if (root == null)			return 0; 
        if (root.right == null)		return 1+minDepthByRecursive(root.left);
        if (root.left == null)		return 1+minDepthByRecursive(root.right); 
        return 1 + Math.min(minDepthByRecursive(root.left), minDepthByRecursive(root.right));
    }
	
	public int minDepth(TreeNode root){
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int levelCnt = 1;
		queue.add(root);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i<size; i++){
				TreeNode current = queue.poll();
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
				if (current.left == null && current.right == null) return levelCnt;
			}
			levelCnt++;
		}
		
		return levelCnt;
	}
}
