package tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
	public static List<Integer> postOrder(TreeNode root){
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
    
    // best logical one
    public List<Integer> postorderIII(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current= root;
        if (current == null)    return list;

        while (current != null || !stack.isEmpty()){
            while(current != null){
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            if (current.right != null){
                stack.add(new TreeNode(current.val));
                current = current.right;
            }
            else {
                list.add(current.val);
                current = null;
            }
        }
        
        return list;
    }
    
    //2015.3.1
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)    return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            while(current.right == null){
                list.add(current.val);
                if(!stack.isEmpty())    current = stack.pop();
                else return list;
            }
            
            stack.push(new TreeNode(current.val));
            current = current.right;
        }
        return list;
    }
    
	
	// recursive
	public List<Integer> postOrderRecursion(TreeNode root) {
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
    
    
    public List<Integer> postOrderRecursionII(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null)  {
        	list.addAll(postOrderRecursionII(root.left));
        	list.addAll(postOrderRecursionII(root.right));
            list.add(root.val);
        }
        return list;
    }
}
