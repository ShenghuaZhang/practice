package tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *       1            <---
 *     /   \
 *    2     3         <---
 *     \     \
 *      5     4       <---
 * You should return [1, 3, 4].
 * 
 * @author yili3
 *  #RightLightFalls
 */
public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)    return list;
        Queue<TreeNode> queue = new LinkedList<>();
		TreeNode current = root;
		queue.add(current);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				current = queue.poll();
				if(i==size-1)	list.add(current.val);
				if(current.left!=null)	queue.add(current.left);
				if(current.right!=null)	queue.add(current.right);
			}
		}
		
		return list;
    }
	
	public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)  return list;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        int height = height(root), finished = 0, curHeight = 1;
        
        while(finished<height){
            while(current!=null){
                if(curHeight>finished){
                    list.add(current.val);
                    finished++;
                }
                stack.push(current);
                current = current.right;
                curHeight++;
            }
            current = stack.pop();
            curHeight--;
            if(current.left!=null){
                stack.push(new TreeNode(current.val));
                current = current.left;
                curHeight++;
            }
            else current = null;
        }
        return list;
    }
    private int height(TreeNode root){
        if(root==null)  return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
