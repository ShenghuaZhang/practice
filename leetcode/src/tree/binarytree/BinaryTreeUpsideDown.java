package tree.binarytree;

public class BinaryTreeUpsideDown {
	public TreeNode UpsideDownBinaryTree(TreeNode root){
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
		return dfsBottomUp(root, null);
	}
	private static TreeNode dfsBottomUp(TreeNode p, TreeNode parrent){
		if (p == null)	return parrent;
		TreeNode root = dfsBottomUp(p.left, p);
		p.left = (parrent == null) ? parrent : parrent.right;
		p.right = parrent;
		return root;
	}
	
	
	public static TreeNode UpsideDownBinaryTreeBottomUpI(TreeNode root){
		return dfsBottomUpI(root, null);
	}
	private static TreeNode dfsBottomUpI(TreeNode p, TreeNode parrent){
		if (p == null)	return parrent;
		TreeNode root = dfsBottomUpI(p.left, p);
		if (parrent == null){
			p.left = null;
			p.right = null;
		}else if (parrent.right == null){
			p.left = null;
			p.right = parrent;
		}else {
			p.left = dfsBottomUpI(parrent.right, null);
			p.right = parrent;
		}return root;
	}
	
	
	public static void main(String[] args){
		System.out.print(LevelOrder.levelOrder(UpsideDownBinaryTreeBottomUp(TreeNode.LeetcodeInitialize("{4,2,6,1,3,5,7}"))));
		System.out.print(LevelOrder.levelOrder(UpsideDownBinaryTreeBottomUpI(TreeNode.LeetcodeInitialize("{4,2,6,1,3,5,7,#,#,#,#,#,#,8,9}"))));
		
	}
}
