package tree.binarysearchtree;
/**
 * 99
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * Could you devise a constant space solution?
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import tree.binarytree.TreeNode;

public class RecoverBinarSearchTree {
	public void recoverTree(TreeNode root) {
		if(root ==null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, first = null, second = null, pre = null;
        
        while(current!=null || !stack.empty()){
            while(current!=null){
                stack.push(current);
                current =current.left;
            }
            current = stack.pop();
            if(pre!=null && current.val<pre.val){
                if(first==null){
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
	
	public void recoverTreeRecursive(TreeNode root) {
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
}
