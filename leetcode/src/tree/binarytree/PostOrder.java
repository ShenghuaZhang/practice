package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
	public List<Integer> postorder(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode>	 stack = new Stack<>();
		TreeNode current = root;

		if (current == null) return list;
		stack.add(current);
		
		while (!stack.isEmpty()){
			current = stack.peek();
			if (current.left == null && current.right == null){
				list.add(current.val);
				stack.pop();
				while(!stack.isEmpty() && (stack.peek().left == current || stack.peek().right == current)){
					current = stack.peek();
					list.add(current.val);
					stack.pop();
				}
			}
			else if (current.right != null)	stack.push(current.right);
			else if (current.left != null) stack.push(current.left);
		}
		
		return list;
	}
	
	public List<Integer> postorderRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		helper(list, root);
		return list;
    }
    private void helper(List<Integer> list, TreeNode root){
        if (root == null)   return;
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }
    
    public List<Integer> postorderRecursionII(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null)  {
        	list.addAll(postorderRecursionII(root.left));
        	list.addAll(postorderRecursionII(root.right));
            list.add(root.val);
        }
        return list;
    }
}
