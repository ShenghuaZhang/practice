package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {
	public static TreeNode findAncestorForBST(TreeNode root, TreeNode A, TreeNode B){
		return helperFindAncestorForBST(root, A, B, null);
	}
	private static TreeNode helperFindAncestorForBST(TreeNode root, TreeNode A, TreeNode B, TreeNode parent){
		if(root.val<A.val && root.val<B.val)
			return helperFindAncestorForBST(root.right, A, B, root);
		if(root.val>A.val && root.val>B.val)
			return helperFindAncestorForBST(root.left, A, B, root);
		if(root.val==A.val || root.val==B.val)
			return parent;
		return root;
	}
	
	public static TreeNode findAncestorForBT(TreeNode root, TreeNode A, TreeNode B){
		List<TreeNode> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		findList(root, A, l1);
		findList(root, B, l2);
		for(int i=0; ; i++){
			if((i>=l1.size() || i>=l2.size()))	return l1.get(i-2);
			if(!SameTree.isSame(l1.get(i), l2.get(i)))	return l1.get(i-1);
		}
		
	}
	private static boolean findList(TreeNode root, TreeNode t, List<TreeNode> list){
		if(root==null)	return false;
		list.add(root);
		if(SameTree.isSame(root, t))	return true;
		if(findList(root.left, t, list))	return true;
		if(findList(root.right, t, list))	return true;
		list.remove(root);
		return false;
	}
	// TODO tree recursive
	public static TreeNode findAncestor(TreeNode root, TreeNode A, TreeNode B, TreeNode parent){
		if(root==null)	return null;
		if(SameTree.isSame(root, A) || SameTree.isSame(root, B))	return parent;
		
		TreeNode left = findAncestor(root.left, A, B, root);
		TreeNode right = findAncestor(root.right, A, B, root);

		if(left!=null && right!=null)	return root;
		return (left!=null)?left:(right!=null)?right:null;
	}
	
	public static void main(String[] args){
		TreeNode root = TreeNode.testRoot();
		System.out.println("\nlevelorder: " + Levelorder.levelorder(root));
		
		TreeNode ancestor = findAncestorForBST(root, root.left.right.right, root.left.right);
		System.out.println("findAncestor for BST: "+ancestor.val);
		
		ancestor = findAncestorForBT(root, root.left.right.right, root.left.right);
		System.out.println("findAncestor get path first: "+ancestor.val);
		
		ancestor = findAncestor(root, root.left.right.right, root.left.right, null);
		System.out.println("findAncestor Recursive: "+ancestor.val);
		
	}
}
