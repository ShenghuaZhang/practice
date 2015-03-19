package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.LevelOrder;
import tree.binarytree.TreeNode;

public class SpiralOrderBTree {
	public static List<List<Integer>> spiralOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)	return list;

		stack.add(root);
		int level = 1;
		while (!stack.empty()) {
			Stack<TreeNode> curStack = new Stack<>();
			List<Integer> curList = new ArrayList<>();
			while(!stack.empty()){
				TreeNode current = stack.pop();
				curList.add(current.val);
				if (level % 2 == 0) {
					if (current.right != null)	curStack.push(current.right);
					if (current.left != null)	curStack.push(current.left);
				} else {
					if (current.left != null)	curStack.push(current.left);
					if (current.right != null)	curStack.push(current.right);
				}
			}
			level++;
			stack = curStack;
			list.add(curList);
		}

		return list;
	}
	
	public static void main(String[] args){
		TreeNode root = TreeNode.LeetcodeInitialize("(4,3,2,5,61,2,0,6,13,9,7,8)");
		System.out.println(LevelOrder.levelOrder(root));
		System.out.print(spiralOrder(root));
	}
}
