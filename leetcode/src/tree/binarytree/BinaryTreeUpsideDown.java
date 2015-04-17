package tree.binarytree;

public class BinaryTreeUpsideDown {
	public static TreeNode UpsideDownBinaryTree(TreeNode root){
		TreeNode p = root, parent = null, parentRight = null;
		while(p != null){
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}

	public static TreeNode UpsideDownBinaryTreeBottomUp(TreeNode root){
		return dfsBottomUpI(root, null);
	}
	private static TreeNode dfsBottomUpI(TreeNode p, TreeNode parent){
		if (p == null)	return parent;
		
		TreeNode root = dfsBottomUpI(p.left, p);
		p.left = (parent == null) ? null : dfsBottomUpI(parent.right, null);
		p.right = parent;
		
		return root;
	}
	
	public static void main(String[] args){
		System.out.println(Levelorder.levelorder(UpsideDownBinaryTreeBottomUp(TreeNode.LeetcodeInitialize("{1,2,3,4,5,6,7}"))));
	}
}
