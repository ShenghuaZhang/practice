package tree.binarytree;

import java.util.HashMap;

import tree.binarytree.TreeNode;

public class ConstructBTFromTraversal {
	public static TreeNode preoderAndInorder(int[] preorder, int[] inorder){
		if (preorder == null || inorder == null) return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
		return preorderAndInorderHelper(preorder, 0, preorder.length-1,
				inorder, 0, inorder.length-1, map);
	}
	private static TreeNode preorderAndInorderHelper(int[] preorder, int preL, int preR, 
			int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
		if (preL > preR || inL > inR)	return null;
		TreeNode root = new TreeNode(preorder[preL]);
		int index = map.get(root.val);
		root.left = preorderAndInorderHelper(preorder, preL+1, index-inL+preL, inorder, inL, index-1, map);
		root.right = preorderAndInorderHelper(preorder, preL+index-inL+1, preR, inorder, index+1, inR, map);
		return root;
	}
	
	public static TreeNode postoderAndInorder(int[] postorder, int[] inorder){
		if (postorder == null || inorder == null) return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
		return postorderAndInorderHelper(postorder, 0, postorder.length-1,
				inorder, 0, inorder.length-1, map);
	}
	private static TreeNode postorderAndInorderHelper(int[] postorder, int postL, int postR, 
			int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
		if (postL > postR || inL > inR)	return null;
		TreeNode root = new TreeNode(postorder[postR]);
		int index = map.get(root.val);
		
		root.left = postorderAndInorderHelper(postorder, postL, postL+index-inL-1, inorder, inL, index-1, map);
		root.right = postorderAndInorderHelper(postorder, postR-(inR-index), postR-1, inorder, index+1, inR, map);
		return root;
	} 
}
