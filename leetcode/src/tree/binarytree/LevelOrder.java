package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        
        if (current == null) return list;
        queue.add(current);
        
        while(!queue.isEmpty()){
        	List<Integer> level = new ArrayList<>();
        	int size = queue.size();
        	for (int j = 0; j < size; j++){
        		current = queue.poll();
        		level.add(current.val);
        		if (current.left != null)	queue.add(current.left);
        		if (current.right != null)	queue.add(current.right);
        	}
        	list.add(level);
        }
        
        return list;
    }
	
	public List<List<Integer>> levelOrderDFS(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if  (root == null) return ret;
		DFShelper (ret, root, 0);
		return ret;
	}
	public void DFShelper(List<List<Integer>> ret, TreeNode root, int level){
		if (root == null)	return;
		else {
			if (level >= ret.size()){
				List<Integer> temp = new ArrayList<>();
				ret.add(temp);
			}
			ret.get(level).add(root.val);
			DFShelper(ret, root.left, level+1);
			DFShelper(ret, root.right, level+1);
		}
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode current = root;
		
		if (current == null) return list;
		queue.add(current);
		
		while (!queue.isEmpty()){
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++){
				current = queue.poll();
				level.add(current.val);
				if (current.left != null)	queue.add(current.left);
				if (current.right != null)	queue.add(current.right);
			}
			list.add(0, level);
		}
		
		return list;
	}
	
	
}
