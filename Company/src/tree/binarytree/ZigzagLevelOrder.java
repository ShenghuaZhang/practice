package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)	return list;
		int level = 1;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while(!stack.empty()){
			List<Integer> levelList = new ArrayList<>();
			Stack<TreeNode> levelStack = new Stack<>();
			while (!stack.empty()){
				TreeNode current = stack.pop();
				levelList.add(current.val);
				if (level%2==0){
					if (current.right != null)	levelStack.push(current.right);
					if (current.left != null)	levelStack.push(current.left);
				}else{
					if (current.left != null)	levelStack.push(current.left);
					if (current.right != null)	levelStack.push(current.right);
				}
			}
			level++;
			stack = levelStack;
			list.add(levelList);
		}
		return list;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode();
		root = TreeNode.testRoot();
		System.out.println(LevelOrder.levelOrder(root));
		System.out.print(zigzagLevelOrder(root));
	}
}
