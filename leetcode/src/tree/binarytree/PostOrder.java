package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
	public List<Integer> postorder(TreeNode root){
		List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)    return list;
        stack.push(root);
        
        while (!stack.isEmpty()){
            TreeNode current = stack.peek();
            if (current.right == null && current.left == null){
                list.add(current.val);
                stack.pop();
                while(!stack.isEmpty() && (stack.peek().right == current || stack.peek().left == current)){
                    current = stack.pop();
                    list.add(current.val);
                }
            }
            else{
                if (current.right != null) stack.push(current.right);
                if (current.left != null)  stack.push(current.left);
            } 
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
    
    public List<Integer> postorderII(TreeNode root){
    	List<Integer> list = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	while (root != null || !stack.isEmpty()){
    		while (root!= null){
    			stack.push(root);
    			root = root.left;
    		}
    		while (!stack.isEmpty()){
    			root = stack.pop();
    			if (root.right != null){
    				stack.push(new TreeNode(root.val));
    				root = root.right;
    				break;
    			}
    			list.add(root.val);
    		}
    	}
		return list;
    }
}
