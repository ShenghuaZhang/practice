package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int j = 0; j < size; j++){
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left!= null)	queue.offer(head.left);
				if (head.right!=null)	queue.offer(head.right);
			}
			result.add(level);
		}
		
		return result;
	}
}
