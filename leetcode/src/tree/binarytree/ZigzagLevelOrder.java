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
		while(!stack.isEmpty()){
			List<Integer> levelList = new ArrayList<>();
			Stack<TreeNode> levelStack = new Stack<>();
			while (!stack.isEmpty()){
				TreeNode current = stack.pop();
				if (level%2==0){
					levelList.add(current.val);
					if (current.right != null)	levelStack.push(current.right);
					if (current.left != null)	levelStack.push(current.left);
				}else{
					levelList.add(current.val);
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
		root.testRoot();
		System.out.print(zigzagLevelOrder(root));
//		System.out.print(LevelOrder.levelOrder(TreeNode.LeetcodeInitialize("{1,2,3,#,#,4,#,#,5}")));
	}
}
