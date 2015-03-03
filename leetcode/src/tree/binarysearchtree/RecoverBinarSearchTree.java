package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.binarytree.LevelOrder;
import tree.binarytree.TreeNode;

public class RecoverBinarSearchTree {
	public void recoverTree(TreeNode root) {
		if (root == null)	return;
		List<TreeNode> pre = new ArrayList<>();
		pre.add(null);
		List<TreeNode> res = new ArrayList<>();
		helper(root, pre, res);
		if (res.size()>0){
			int temp = res.get(0).val;
			res.get(0).val = res.get(1).val;
			res.get(1).val = temp;
		}
	}
	private void helper(TreeNode root, List<TreeNode> pre, List<TreeNode> res){
		if(root == null)	return;
		helper(root.left, pre, res);
		if (pre.get(0)!=null && pre.get(0).val > root.val){
			if (res.size() == 0){
				res.add(pre.get(0));
				res.add(root);
			}else	res.set(1, root);
		}
		pre.set(0, root);
		helper(root.right, pre, res);
	}
	
	public static void recoverTreeII(TreeNode root) {
		if(root ==null) return;
        int flag = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, first = root, second = root, pre = root;
        
        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current =current.left;
            }
            current = stack.pop();
            if(flag==0)	flag++;
            else if(current.val<pre.val){
                if(flag==1){
                    flag++;
                    first = pre;
                    second = current;
                }else	second = current;
            }
            pre = current;
            current = current.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
	
	public static void main(String[] args){
		TreeNode root = TreeNode.LeetcodeInitialize("{3,1,2}");
		recoverTreeII(root);
		System.out.println(LevelOrder.levelOrder(root));
	}
}
